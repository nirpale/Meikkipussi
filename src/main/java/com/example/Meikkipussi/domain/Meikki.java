package com.example.Meikkipussi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Meikki {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nimi, valmistaja, koko, hinta;
	
	@ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;
	
	public Meikki() {
		
	}

	public Meikki(long id, String nimi, String valmistaja, String koko, String hinta, Category category) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.valmistaja = valmistaja;
		this.koko = koko;
		this.hinta = hinta;
		this.category = category;
	}
	
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getValmistaja() {
		return valmistaja;
	}

	public void setValmistaja(String valmistaja) {
		this.valmistaja = valmistaja;
	}

	public String getKoko() {
		return koko;
	}

	public void setKoko(String koko) {
		this.koko = koko;
	}

	public String getHinta() {
		return hinta;
	}

	public void setHinta(String hinta) {
		this.hinta = hinta;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Meikki [nimi=" + nimi + ", valmistaja=" + valmistaja + ", koko=" + koko + ", hinta=" + hinta 
					+ " category =" + this.getCategory() + "]";		
		else
			return "Meikki [nimi=" + nimi + ", valmistaja=" + valmistaja + ", koko=" + koko + ", hinta=" + hinta + "]";
	}
	
}
