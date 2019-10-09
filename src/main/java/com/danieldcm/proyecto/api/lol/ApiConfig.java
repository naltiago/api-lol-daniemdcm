package com.danieldcm.proyecto.api.lol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.danieldcm.proyecto.api.lol.config.PathsJson;



@Configuration
@PropertySource("classpath:paths.properties")
public class ApiConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public PathsJson pathJson(){
		PathsJson pathsJson = new PathsJson();
		
		pathsJson.setPathJson(env.getProperty("paths-json-champions"));
		pathsJson.setPathSummoner(env.getProperty("paths-url-summoners"));
		pathsJson.setApiKey(env.getProperty("api-key-riot"));
		pathsJson.setPathHttp(env.getProperty("path-http-standar"));
		pathsJson.setPathMastery(env.getProperty("paths-url-champions-mastery"));
		return pathsJson;
	};
	
	
}