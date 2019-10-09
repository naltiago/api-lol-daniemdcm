package com.danieldcm.proyecto.api.lol.model.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.danieldcm.proyecto.api.lol.config.PathsJson;
import com.danieldcm.proyecto.api.lol.model.entity.Champions;
import com.danieldcm.proyecto.api.lol.model.entity.ChampionsMastery;
import com.danieldcm.proyecto.api.lol.model.entity.Summoner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/champions")
public class ChampionsRestController {

	
	private static final String MESSAGE = "message";
	private static final String ERROR = "error";
	
	private static final Log log = LogFactory.getLog(ChampionsRestController.class);
	
	@Autowired
	PathsJson pathJson;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/nameclient/{name}")
	public ResponseEntity<?> entityGetSummonerByName(@PathVariable String name) {
		log.info("Llamada a entityGetSummonerByName con la variable name -> " + name);
		Map<String, Object> response = new HashMap<>();
		Map<Object, Object> responseOk = new HashMap<>();
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> headers = new HttpEntity<>(header);

		try {
			
			String jsonSummoner = restTemplate.exchange(pathJson.getPathHttp()
											  + pathJson.getPathSummoner() + name + "?api_key=" 
											  + pathJson.getApiKey(),
											  	HttpMethod.GET, headers, String.class)
											   .getBody();
						
			ObjectMapper mapper = new ObjectMapper();
			
			Summoner sum = mapper.readValue(jsonSummoner, Summoner.class);
			
			String jsonChampionsMastery = restTemplate.exchange(pathJson.getPathHttp()
					  + pathJson.getPathMastery() + sum.getId() + "?api_key=" 
					  + pathJson.getApiKey(),
					  	HttpMethod.GET, headers, String.class)
					   .getBody();
			
			List<ChampionsMastery> listChampionsMastery  = Arrays.asList(mapper.readValue(jsonChampionsMastery, ChampionsMastery[].class));

			responseOk.put(sum.getName(), listChampionsMastery);
			response.put(MESSAGE, "La llamada se ha hecho correctamente");
			response.put("summoner", responseOk);
			
			log.info("La llamada se ha hecho correctamente y el summoner " + sum.getName() + 
					" se ha guardado correctamente");	

		
		} catch (JsonParseException | JsonMappingException e) {
			log.error("Ha ocurrido un error en el parseo o el mapeo del json " + e.getOriginalMessage());
			response.put(MESSAGE, "Ha ocurrido un error con el mapeo");
			response.put(ERROR, e.getOriginalMessage());
			
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (IOException e) {
			log.error("Ha ocurrido un error en la lectura del fichero " + e.getCause().getMessage());
			response.put(MESSAGE, "HA ocurrido un error con el fichero");
			response.put(ERROR, e.getCause().getMessage());
			
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch(HttpClientErrorException ex) {
			
			log.error("Ha ocurrido un error al recoger los datos de la api " + ex.getMessage());
			response.put(MESSAGE, "HA ocurrido un error con el fichero");
			response.put(ERROR, ex.getMessage());				
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/listar/champions")
	public ResponseEntity<?> getAllChampions(){
		
		Map<String, Object> response = new HashMap();
		
		ObjectMapper mapper = new ObjectMapper();
			
		try {
			
			Champions[] champions =  mapper.readValue(new File(pathJson.getPathJson()), Champions[].class);
			response.put(MESSAGE, "La llamada se ha hecho correctamente");
			response.put("champions", champions);

		} catch (JsonParseException | JsonMappingException e) {
			response.put(MESSAGE, "Ha ocurrido un error con el parseo del json");
			response.put(ERROR, e.getOriginalMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			
		} catch (IOException e) {
			response.put(MESSAGE, "Ha ocurrido un error con el fichero");
			response.put(ERROR, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);	
			
		}
			
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}	
	
}
