package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Obvestilo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "administrator")
	@JsonIgnore
	Administrator administrator;
	private int idObvestilo;

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne( fetch= FetchType.LAZY)
	@JoinColumn(name ="Administrator_id")
	@OnDelete( action= OnDeleteAction.CASCADE) // vse se zbrise
	@JsonIgnore
	/**
	 * 
	 * @param obvestilo
	 */
	public void getObvestilo(String obvestilo) {
		// TODO - implement Obvestilo.getObvestilo
		throw new UnsupportedOperationException();
	}

}