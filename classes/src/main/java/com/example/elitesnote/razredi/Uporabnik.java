package com.example.elitesnote.razredi;

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

	@OneToOne
	@JoinColumn(name = "profil_id")
	@JsonIgnore
	Profil profil;

	/*@ManyToOne
	@JoinColumn(name = "seznam")
	@JsonIgnore
	Seznam seznam;

	 */

	@OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Collection<Skupina> seznami;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skupina_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Skupina skupina;

	@OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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


	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
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