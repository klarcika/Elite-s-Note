package com.example.elitesnote.razredi;

import com.example.elitesnote.dao.Vloga;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
public class Uporabnik {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	/*@ManyToOne
	@JoinColumn(name = "seznam")
	@JsonIgnore
	Seznam seznam;

	 */

	@OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Collection<Seznam> seznami;

	@ManyToMany(mappedBy = "uporabniki", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Collection<Skupina> skupine;

	private String uporabniskoIme;
	private String geslo;
	private Vloga vloga = Vloga.UPORABNIK;

	private int stSeznamov;
	public int getStSeznamov() {
		return stSeznamov;
	}

	public void setStSeznamov(int stSeznamov) {
		this.stSeznamov = stSeznamov;
	}

	private int stSkupin;
	public int getStSkupin() {
		return stSkupin;
	}

	public void setStSkupin(int stSkupin) {
		this.stSkupin = stSkupin;
	}

	public Vloga getVloga() {
		return vloga;
	}

	public Collection<Seznam> getSeznami() {
		return seznami;
	}

	public Collection<Skupina> getSkupine() {
		return skupine;
	}

	public void setSeznami(Collection<Seznam> seznami) {
		this.seznami = seznami;
	}

	public void setSkupine(Collection<Skupina> skupine) {
		this.skupine = skupine;
	}

	public void setVloga(Vloga vloga) {
		this.vloga = vloga;
	}

	public Uporabnik() {
	}

	public Collection<Skupina> getSkupina() {
		return skupine;
	}

	public void setSkupina(Collection<Skupina> skupina) {
		this.skupine = skupina;
	}
	public String getUporabniskoIme() {
		return this.uporabniskoIme;
	}

	public void setUporabniskoIme(String uporabniskoIme) {
		this.uporabniskoIme = uporabniskoIme;
	}

	public String getGeslo() {
		return this.geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @param uporabniskoIme
	 * @param geslo
	 */
	public Uporabnik(String uporabniskoIme, String geslo) {
		// TODO - implement Uporabnik.Uporabnik
		throw new UnsupportedOperationException();
	}

}