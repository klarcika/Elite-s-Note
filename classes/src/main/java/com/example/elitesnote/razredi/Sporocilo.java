package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;

@Entity
public class Sporocilo {
@Id
    @GenerateValue(strategy= GenerationType.AUTO)
    private Long id;

    Uporabnik uporabniskoIme;
        private int idSporocilo;

    @ManyToOne( fetch= FetchType.LAZY)
    @JoinColumn(name ="Uporabnik_id")
    @OnDelete( action= OnDeleteAction.CASCADE) // vse se zbrise
    @JsonIgnore

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