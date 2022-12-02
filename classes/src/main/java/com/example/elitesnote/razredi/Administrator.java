package com.example.elitesnote.razredi;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.*;

@Entity
public class Administrator {

	@Id
	@GenerateValue(strategy= GenerationType.AUTO) // ru si mors maven updejtat da bo delalo
	private Long id;

	private String adminIme;
	private String geslo;

	public String getAdminIme() {
		return this.adminIme;
	}

	public void setAdminIme(String adminIme) {
		this.adminIme = adminIme;
	}

	public String getGeslo() {
		return this.geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}


	@OneToMany(mappedBy= "Administrator", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Vsebina> vsebina;

	@OneToMany(mappedBy= "Administrator", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Sporocilo> sporocilo;

	@OneToMany(mappedBy= "Administrator", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Obvestilo> obvestilo;
	/**
	 * 
	 * @param adminIme
	 * @param geslo
	 */
	public Administrator(String adminIme, String geslo) {
		// TODO - implement Administrator.Administrator
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param naslov
	 * @param opis
	 */
	public void dodajVsebino(String naslov, String opis) {
		// TODO - implement Administrator.dodajVsebino
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vsebina
	 * @param naslov
	 * @param opis
	 */
	public void spremeniVsebino(Vsebina vsebina, String naslov, String opis) {
		// TODO - implement Administrator.spremeniVsebino
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vsebina
	 */
	public void izbrisiVsebino(Vsebina vsebina) {
		// TODO - implement Administrator.izbri�iVsebino
		throw new UnsupportedOperationException();
	}

}