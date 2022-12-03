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
    @JoinColumn(name = "uporabnisko_ime_ID")
    @JsonIgnore
    Uporabnik uporabniskoIme;
        private int idSporocilo;

    public Uporabnik getUporabniskoIme() {
        return uporabniskoIme;
    }

    public void setUporabniskoIme(Uporabnik uporabniskoIme) {
        this.uporabniskoIme = uporabniskoIme;
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