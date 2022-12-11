package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Sporocilo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uporabnik")
    @JsonIgnore
    private Uporabnik uporabnik;

    @ManyToOne
    @JoinColumn(name = "administrator")
    @JsonIgnore
    private Administrator administrator;
    private int idSporocilo;

    public Uporabnik getUporabniskoIme() {
        return uporabnik;
    }

    public void setUporabniskoIme(Uporabnik uporabniskoIme) {
        this.uporabnik = uporabniskoIme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    /**
     *
     * @param uporabniskoIme
     */

    public void prejemnikSporocila(Uporabnik uporabniskoIme){
        // TODO - implement Sporocilo.prejemnikSporocila
        throw new UnsupportedOperationException();
    }

        /**
         *
         * @param sporocilo
         */
        public void napisiSporocilo(String sporocilo) {
            // TODO - implement Sporocilo.napisiSporocilo
            throw new UnsupportedOperationException();



        }
}