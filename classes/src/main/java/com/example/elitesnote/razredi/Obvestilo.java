package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Obvestilo {

	@Id
	@GenerateValue(strategy= GenerationType.AUTO)
	private Long id;
	Administrator administrator;
	private int idObvestilo;

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