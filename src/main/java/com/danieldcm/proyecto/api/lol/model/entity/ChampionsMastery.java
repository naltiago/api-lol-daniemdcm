package com.danieldcm.proyecto.api.lol.model.entity;

import java.io.Serializable;

public class ChampionsMastery implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Boolean chestGranted;
	
	private Integer championLevel;
	
	private Integer championPoints;
	
	private Long championId;
	
	private Long championPointsUntilNextLevel;
	
	private Long lastPlayTime;
	
	private Integer tokensEarned;
	
	private Long championPointsSinceLastLevel;
	
	private String summonerId;

	public Boolean getChestGranted() {
		return chestGranted;
	}

	public void setChestGranted(Boolean chestGranted) {
		this.chestGranted = chestGranted;
	}

	public Integer getChampionLevel() {
		return championLevel;
	}

	public void setChampionLevel(Integer championLevel) {
		this.championLevel = championLevel;
	}

	public Integer getChampionPoints() {
		return championPoints;
	}

	public void setChampionPoints(Integer championPoints) {
		this.championPoints = championPoints;
	}

	public Long getChampionId() {
		return championId;
	}

	public void setChampionId(Long championId) {
		this.championId = championId;
	}

	public Long getChampionPointsUntilNextLevel() {
		return championPointsUntilNextLevel;
	}

	public void setChampionPointsUntilNextLevel(Long championPointsUntilNextLevel) {
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
	}

	public Long getLastPlayTime() {
		return lastPlayTime;
	}

	public void setLastPlayTime(Long lastPlayTime) {
		this.lastPlayTime = lastPlayTime;
	}

	public Integer getTokensEarned() {
		return tokensEarned;
	}

	public void setTokensEarned(Integer tokensEarned) {
		this.tokensEarned = tokensEarned;
	}

	public Long getChampionPointsSinceLastLevel() {
		return championPointsSinceLastLevel;
	}

	public void setChampionPointsSinceLastLevel(Long championPointsSinceLastLevel) {
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	
}
