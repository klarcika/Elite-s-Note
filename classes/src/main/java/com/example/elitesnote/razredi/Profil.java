package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;

@Entity
public class Profil {


    Uporabnik uporabnik;
    @Id
    @GenerateValue(strategy= GenerationType.AUTO) // ru si mors maven updejtat da bo delalo
    private Long id;
    private byte profilnaSlika;

    public void setProfilnaSlika(byte profilnaSlika) {
        this.profilnaSlika = profilnaSlika;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="hisa_id")
    @OnDelete( action= OnDeleteAction.CASCADE) // vse se zbrise
    @JsonIgnore
    /**
     * @param slika
     * @param uporabnik
     */
    public Profil(byte slika, Uporabnik uporabnik) {
        // TODO - implement Urejanje.Profil
        throw new UnsupportedOperationException();
    }

    /**
     * @param spremenjen
     */
    public void spremeniProfil(Urejanje spremenjen) {
        // TODO - implement Urejanje.spremeniProfil
        throw new UnsupportedOperationException();
    }

}