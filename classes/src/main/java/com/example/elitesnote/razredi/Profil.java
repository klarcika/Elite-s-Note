package com.example.elitesnote.razredi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Profil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "uporabnik_ID")
    @JsonIgnore
    Uporabnik uporabnik;

    public byte getProfilnaSlika() {
        return profilnaSlika;
    }

    private byte profilnaSlika;

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profil() {
    }

    public void setProfilnaSlika(byte profilnaSlika) {
        this.profilnaSlika = profilnaSlika;
    }




    /**
     * @param slika
     * @param uporabnik
     */
    public Profil(byte slika, Uporabnik uporabnik) {
        // TODO - implement Urejanje.Profil
        throw new UnsupportedOperationException();
    }

    /**
     * @param slika
     */
    public void spremeniSliko(byte slika) {
        // TODO - implement Profil.spremeniSliko
        throw new UnsupportedOperationException();
    }
    /**
     * @param geslo
     */
    public void spremeniGeslo(String geslo) {
        // TODO - implement Profil.spremeniGeslo
        throw new UnsupportedOperationException();
    }

}