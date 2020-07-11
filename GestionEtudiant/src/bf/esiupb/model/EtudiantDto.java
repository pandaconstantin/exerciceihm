/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bf.esiupb.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author root
 */
public class EtudiantDto {
    private StringProperty matricule;

    public StringProperty matriculeProperty() {
        if(matricule == null) matricule = new SimpleStringProperty(this, "Matricule");
        return matricule;
    }
    
    public void setMatricule(String value) {
        matriculeProperty().set(value);
    }

    public EtudiantDto(String matricule) {
        this.setMatricule(matricule);
    }
    
    
    
}
