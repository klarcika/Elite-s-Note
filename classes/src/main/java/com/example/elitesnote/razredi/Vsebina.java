package com.example.elitesnote.razredi;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class
Vsebina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	@ManyToOne( fetch= FetchType.LAZY)
	@JoinColumn(name ="Administrator_id")
	@OnDelete( action= OnDeleteAction.CASCADE) // vse se zbrise
	@JsonIgnore

	private String naslov;
	private String opis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vsebina() {
	}

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
		// TODO - implement Vsebina.všečkajVsebino
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