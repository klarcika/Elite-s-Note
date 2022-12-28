package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
@Table(name = "uporabnik")
public class Uporabnik {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Collection<Seznam> seznami;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skupina")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Skupina skupina;

	 */

	@ManyToMany(mappedBy = "uporabniki", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Collection<Skupina> skupine;

	private String uporabniskoIme;
	private String geslo;

	public int getStSeznamov() {
		return stSeznamov;
	}

	public void setStSeznamov(int stSeznamov) {
		this.stSeznamov = stSeznamov;
	}

	private int stSeznamov;

	public int getStSkupin() {
		return stSkupin;
	}

	public void setStSkupin(int stSkupin) {
		this.stSkupin = stSkupin;
	}

	private int stSkupin;

	public Uporabnik() {
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