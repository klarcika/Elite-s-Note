package com.example.elitesnote.razredi;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Entity
public class Vsebina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne( fetch= FetchType.LAZY)
	@JoinColumn(name ="administrator_id")// vse se zbrise
	private Administrator administrator;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seznam")
	@OnDelete( action= OnDeleteAction.CASCADE) // vse se zbrise
	@JsonIgnore
	private Seznam seznam;

	private String naslov;
	private String opis;
	private String zanr;

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

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Seznam getSeznam() {
		return seznam;
	}

	public void setSeznam(Seznam seznam) {
		this.seznam = seznam;
	}
}