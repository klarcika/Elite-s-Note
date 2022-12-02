package com.example.elitesnote.razredi;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.*;

@Entity
public class Uporabnik {
	@Id
	@GenerateValue(strategy= GenerationType.AUTO) // ru si mors maven updejtat da bo delalo
	private Long id;


	Profil profil;


	private int idUporabnika;
	private String uporabniskoIme;
	private String geslo;

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


	@OneToMany(mappedBy= "Uporabnik", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Seznam> seznam;

	@OneToMany(mappedBy= "Uporabnik", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Skupina> skupina;

	@OneToMany(mappedBy= "Uporabnik", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Sporocilo> sporocila;
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