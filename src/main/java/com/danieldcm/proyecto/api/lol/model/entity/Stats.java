package com.danieldcm.proyecto.api.lol.model.entity;

import java.io.Serializable;


public class Stats implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer hp;
	
	private Integer hpperlevel;
	
	private Integer mp;
	
	private Integer mpperlevel;
	
	private Integer movespeed;
	
	private Double armor;
	
	private Double armorperlevel;
	
	private Double spellblock;
	
	private Double spellblockperlevel;
	
	private Double attackrange;
	
	private Double hpregen;
	
	private Double hpregenperlevel;
	
	private Double mpregen;
	
	private Double mpregenperlevel;
	
	private Double crit;
	
	private Double critperlevel;
	
	private Double attackdamage;
	
	private Double attackdamageperlevel;
	
	private Double attackspeedoffset;
	
	private Double attackspeedperlevel;

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getHpperlevel() {
		return hpperlevel;
	}

	public void setHpperlevel(Integer hpperlevel) {
		this.hpperlevel = hpperlevel;
	}

	public Integer getMp() {
		return mp;
	}

	public void setMp(Integer mp) {
		this.mp = mp;
	}

	public Integer getMpperlevel() {
		return mpperlevel;
	}

	public void setMpperlevel(Integer mpperlevel) {
		this.mpperlevel = mpperlevel;
	}

	public Integer getMovespeed() {
		return movespeed;
	}

	public void setMovespeed(Integer movespeed) {
		this.movespeed = movespeed;
	}

	public Double getArmor() {
		return armor;
	}

	public void setArmor(Double armor) {
		this.armor = armor;
	}

	public Double getArmorperlevel() {
		return armorperlevel;
	}

	public void setArmorperlevel(Double armorperlevel) {
		this.armorperlevel = armorperlevel;
	}

	public Double getSpellblock() {
		return spellblock;
	}

	public void setSpellblock(Double spellblock) {
		this.spellblock = spellblock;
	}

	public Double getSpellblockperlevel() {
		return spellblockperlevel;
	}

	public void setSpellblockperlevel(Double spellblockperlevel) {
		this.spellblockperlevel = spellblockperlevel;
	}

	public Double getAttackrange() {
		return attackrange;
	}

	public void setAttackrange(Double attackrange) {
		this.attackrange = attackrange;
	}

	public Double getHpregen() {
		return hpregen;
	}

	public void setHpregen(Double hpregen) {
		this.hpregen = hpregen;
	}

	public Double getHpregenperlevel() {
		return hpregenperlevel;
	}

	public void setHpregenperlevel(Double hpregenperlevel) {
		this.hpregenperlevel = hpregenperlevel;
	}

	public Double getMpregen() {
		return mpregen;
	}

	public void setMpregen(Double mpregen) {
		this.mpregen = mpregen;
	}

	public Double getMpregenperlevel() {
		return mpregenperlevel;
	}

	public void setMpregenperlevel(Double mpregenperlevel) {
		this.mpregenperlevel = mpregenperlevel;
	}

	public Double getCrit() {
		return crit;
	}

	public void setCrit(Double crit) {
		this.crit = crit;
	}

	public Double getCritperlevel() {
		return critperlevel;
	}

	public void setCritperlevel(Double critperlevel) {
		this.critperlevel = critperlevel;
	}

	public Double getAttackdamage() {
		return attackdamage;
	}

	public void setAttackdamage(Double attackdamage) {
		this.attackdamage = attackdamage;
	}

	public Double getAttackdamageperlevel() {
		return attackdamageperlevel;
	}

	public void setAttackdamageperlevel(Double attackdamageperlevel) {
		this.attackdamageperlevel = attackdamageperlevel;
	}

	public Double getAttackspeedoffset() {
		return attackspeedoffset;
	}

	public void setAttackspeedoffset(Double attackspeedoffset) {
		this.attackspeedoffset = attackspeedoffset;
	}

	public Double getAttackspeedperlevel() {
		return attackspeedperlevel;
	}

	public void setAttackspeedperlevel(Double attackspeedperlevel) {
		this.attackspeedperlevel = attackspeedperlevel;
	}
		
}