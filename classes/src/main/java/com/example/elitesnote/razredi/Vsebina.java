package com.example.elitesnote.razredi;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;

@Entity
public class Vsebina {

	@Id
	@GenerateValue(strategy= GenerationType.AUTO)
	private Long id;


	private String naslov;
	private String opis;

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@ManyToOne( fetch= FetchType.LAZY)
	@JoinColumn(name ="Administrator_id")
	@OnDelete( action= OnDeleteAction.CASCADE) // vse se zbrise
	@JsonIgnore
	/**
	 *
	 * @param naslov
	 * @param opis
	 */
	public Vsebina(String naslov, String opis) {


		// TODO - implement Vsebina.Vsebina
		throw new UnsupportedOperationException();
	}

	public void vseckajkajVsebino() {
		// TODO - implement Vsebina.v�e�kajVsebino
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param �tzvezdic
	 */
	public void oceniVsebino(int stZvezdic) {
		// TODO - implement Vsebina.oceniVsebino
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param komentar
	 */
	public void komentirajVsebino(String komentar) {
		// TODO - implement Vsebina.komentirajVsebino
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazivSeznama
	 */
	public void dodajNaSeznam(String nazivSeznama) {
		// TODO - implement Vsebina.dodajNaSeznam
		throw new UnsupportedOperationException();
	}

}