package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Seznam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "uporabnik_ID")
	@JsonIgnore
	Uporabnik uporabnik;
	private String imeSeznama;

	public String getImeSeznama() {
		return imeSeznama;
	}

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

	public void setImeSeznama(String imeSeznama) {
		this.imeSeznama = imeSeznama;
	}

	/**
	 * 
	 * @param naslovVsebine
	 */
	public void izbrisiVsebino(String naslovVsebine) {
		// TODO - implement Seznam.izbri�iVsebino
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param naziv
	 */
	public void dodajSeznam(String naziv) {
		// TODO - implement Seznam.dodajSeznam
		throw new UnsupportedOperationException();
	}

}