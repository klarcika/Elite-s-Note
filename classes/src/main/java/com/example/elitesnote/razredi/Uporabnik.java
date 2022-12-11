package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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

	public Collection<Seznam> getSeznam() {
		return seznam;
	}

	public void setSeznam(Collection<Seznam> seznam) {
		this.seznam = seznam;
	}

	public Collection<Skupina> getSkupina() {
		return skupina;
	}

	public void setSkupina(Collection<Skupina> skupina) {
		this.skupina = skupina;
	}

	@OneToMany(mappedBy= "uporabnik", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Seznam> seznam;

	@OneToMany(mappedBy= "uporabnik", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Skupina> skupina;

	@OneToMany(mappedBy= "uporabnik", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Sporocilo> sporocila;


	private int idUporabnika;
	private String uporabniskoIme;
	private String geslo;

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