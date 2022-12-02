package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;

@Entity
public class Skupina {
	@Id
	@GenerateValue(strategy= GenerationType.AUTO)
	private Long id;
	Uporabnik uporabnik;
	private String naziv;
	private int stUporabnikov;

	public String getNaziv() {
		return this.naziv;
	}

	public int getstUporabnikov() {
		return this.stUporabnikov;
	}

	@ManyToOne( fetch= FetchType.LAZY)
	@JoinColumn(name ="Uporabnik_id")
	@OnDelete( action= OnDeleteAction.CASCADE) // vse se zbrise
	@JsonIgnore
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