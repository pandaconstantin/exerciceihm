/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bf.esiupb.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Constantin Drabo
 */
@Entity
public class Etudiant implements Serializable {
    
    @Id
    private Integer matricule;
    private String nom;
    private String prenom;
    private LocalDate dateNaissaince;
    private char sexe;

    public Etudiant() {
    }

    public Etudiant(Integer matricule, String nom, String prenom, LocalDate dateNaissaince, char sexe) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissaince = dateNaissaince;
        this.sexe = sexe;
    }
    
    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissaince() {
        return dateNaissaince;
    }

    public void setDateNaissaince(LocalDate dateNaissaince) {
        this.dateNaissaince = dateNaissaince;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

}
