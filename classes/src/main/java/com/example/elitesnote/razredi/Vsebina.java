package com.example.elitesnote.razredi;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//to bi lahko delalo
//samo ne vem zakaj ne dela
@Entity
public class
Vsebina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	@ManyToOne( fetch= FetchType.LAZY)
	@JoinColumn(name ="administrator")// vse se zbrise
	private Administrator administrator;

<<<<<<< HEAD

	@ManyToOne(fetch=FetchType.LAZY)
=======
	@OneToMany(fetch=FetchType.LAZY)
>>>>>>> 5621498b4f7fc21071e8f3d7f65a1ab29d0e5f62
	@JoinColumn(name="Seznam_id")
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

}