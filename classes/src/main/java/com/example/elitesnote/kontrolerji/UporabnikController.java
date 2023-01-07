package com.example.elitesnote.kontrolerji;

import com.example.elitesnote.dao.UporabnikRepository;
import com.example.elitesnote.razredi.Uporabnik;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uporabnik")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikDao;

    @PostMapping("/dodaj_uporabnika")
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik){
        return uporabnikDao.save(uporabnik);
    }

    // Sprint 2
    @GetMapping("/vsiUporabniki")
    public Iterable<Uporabnik> vrniUporabnika(){
        return uporabnikDao.findAll();
    }

    @GetMapping("/stevilo_seznamov/{stSeznam}")
    public Iterable<Uporabnik> vrniStSeznamovUporabnika(@PathVariable(name = "stSeznam") int stSeznamov){
        return uporabnikDao.vrniStSeznamovUporabnika();
    }

    // Projekt/Sprint 1; poizvedba s 3 parametri
    @GetMapping("/s_seznami_in_skupinami/{ime}/{stSeznamov}/{stSkupin}")
    public Iterable<Uporabnik> uporabnikiSSeznamiInSkupinami(@PathVariable("ime") String ime, @PathVariable("stSeznamov") int stSeznamov,
                                                             @PathVariable("stSkupin") int stSkupin){
        return uporabnikDao.seznamiInSkupine(ime, stSeznamov, stSkupin);
    }

    // Sprint 1; spreminjanje podatkov zapisa
    @PutMapping("/profil_spremeni/id/{id}")
    public ResponseEntity<Uporabnik> spremeniProfil(@PathVariable(name = "id") Long id, @RequestBody Uporabnik podrobnosti){
        Optional<Uporabnik> profil = uporabnikDao.findById(id);

        Uporabnik pr = profil.get();
        uporabnikDao.delete(pr);
        pr = podrobnosti;

        uporabnikDao.save(pr);

        return ResponseEntity.ok(pr);
    }

    // registracija
    @PostMapping("/registracija")
    public boolean registracijaUporabnika(@RequestBody Uporabnik uporabnik) throws NoSuchAlgorithmException {
        List<Uporabnik> tempUporabnik = uporabnikDao.preveriCeUporabnikObstaja(uporabnik.getUporabniskoIme());
        if(tempUporabnik.size() > 0){
            // uporabnik že obstaja
            return false;
        }
        String geslo = uporabnik.getGeslo();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(geslo.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        String hex = String.format("%064x", new BigInteger(1, digest));
        uporabnik.setGeslo(hex);
        System.out.println(uporabnik.getGeslo());
        uporabnikDao.save(uporabnik);
        System.out.println("Registracija uspešna");
        return true;
    }

    // prijava
    @PostMapping("/prijava")
    public boolean vrniLogin(@RequestBody ObjectNode objectNode) throws NoSuchAlgorithmException {
        System.out.println(objectNode);

        String geslo = objectNode.get("geslo").asText();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(geslo.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        String hex = String.format("%064x", new BigInteger(1, digest));

        List<Uporabnik> tempUporabnik = uporabnikDao.vrniLogin(hex, objectNode.get("email").asText());
        System.out.println(tempUporabnik);
        if(tempUporabnik.size() > 0){
            System.out.println("Prijava uspešna");
            return true;
        }
        return false;
    }
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
