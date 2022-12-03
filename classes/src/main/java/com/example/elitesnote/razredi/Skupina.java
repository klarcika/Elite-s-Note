package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Skupina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@ManyToOne
	@JoinColumn(name = "uporabnik_ID")
	@JsonIgnore
	Uporabnik uporabnik;
	private String naziv;
	private int stUporabnikov;

	public Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public int getstUporabnikov() {
		return this.stUporabnikov;
	}


	/**
	 * 
	 * @param nazivSkupine
	 */
	public void ustvariSkupino(String nazivSkupine) {
		// TODO - implement Skupina.ustvariSkupino
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uporabnik
	 */
	public void dodajUporabnika(Uporabnik uporabnik) {
		// TODO - implement Skupina.dodajUporabnika
		throw new UnsupportedOperationException();
	}

}