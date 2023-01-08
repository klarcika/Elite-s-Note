package com.example.elitesnote.razredi;

import com.example.elitesnote.dao.AdministratorRepository;
import com.example.elitesnote.dao.Vloga;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Entity
public class Administrator {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	private String adminIme;
	private String geslo;
	private Vloga vloga = Vloga.ADMINISTRATOR;

	public Administrator() {
	}

	public String getAdminIme() {
		return this.adminIme;
	}

	public void setAdminIme(String adminIme) {
		this.adminIme = adminIme;
	}

	public String getGeslo() {
		return this.geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public Collection<Vsebina> getVsebina() {
		return vsebina;
	}

	public void setVsebina(Collection<Vsebina> vsebina) {
		this.vsebina = vsebina;
	}

	@OneToMany(mappedBy= "administrator", fetch= FetchType.LAZY,cascade= CascadeType.ALL) // relacija
	Collection<Vsebina> vsebina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vloga getVloga() {
		return vloga;
	}

	public void setVloga(Vloga vloga) {
		this.vloga = vloga;
	}

	/**
	 * 
	 * @param adminIme
	 * @param geslo
	 */
	public Administrator(String adminIme, String geslo) {
		// TODO - implement Administrator.Administrator
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param naslov
	 * @param opis
	 */
	public void dodajVsebino(String naslov, String opis) {
		// TODO - implement Administrator.dodajVsebino
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vsebina
	 * @param naslov
	 * @param opis
	 */
	public void spremeniVsebino(Vsebina vsebina, String naslov, String opis) {
		// TODO - implement Administrator.spremeniVsebino
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vsebina
	 */
	public void izbrisiVsebino(Vsebina vsebina) {
		// TODO - implement Administrator.izbrisiVsebino
		throw new UnsupportedOperationException();
	}

}