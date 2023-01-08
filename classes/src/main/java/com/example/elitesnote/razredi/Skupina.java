package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

@Entity
@Table(name = "skupina")
public class Skupina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uporabnik_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Uporabnik uporabnik;
	 */

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "skupina_uporabnik",
		joinColumns = @JoinColumn(name = "skupina_id"),
		inverseJoinColumns = @JoinColumn(name = "uporabnik_id"))
	Collection<Uporabnik> uporabniki;

	private String naziv;
	private int stUporabnikov;

	public Long getId() {
		return id;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public int getStUporabnikov() {
		return this.stUporabnikov;
	}

	public void setStUporabnikov(int stUporabnikov) {
		this.stUporabnikov = stUporabnikov;
	}

	public Collection<Uporabnik> getUporabniki() {
		return uporabniki;
	}

	public void setUporabniki(Collection<Uporabnik> uporabniki) {
		this.uporabniki = uporabniki;
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