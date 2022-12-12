package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

@Entity
public class Skupina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@OneToMany(mappedBy= "uporabniki", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Uporabnik> uporabniki;
	private String naziv;
	private int stUporabnikov;

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