package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;

@Entity
public class Seznam {
	@Id
	@GenerateValue(strategy= GenerationType.AUTO)
	private Long id;
	Uporabnik uporabnik;
	private String imeSeznama;

	public void setImeSeznama(String imeSeznama) {
		this.imeSeznama = imeSeznama;
	}

	@ManyToOne( fetch= FetchType.LAZY)
	@JoinColumn(name ="Uporabnik_id")
	@OnDelete( action= OnDeleteAction.CASCADE) // vse se zbrise
	@JsonIgnore
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