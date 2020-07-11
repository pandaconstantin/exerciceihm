/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bf.esiupb.controleur;

import bf.esiupb.model.Etudiant;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Constantin DRABO
 */
public class enregistrerControleur implements Initializable {

    @FXML
    private TextField txtmatricule;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private DatePicker datenaissance;
    @FXML
    private RadioButton radiomasculin;
    @FXML
    private RadioButton radiofeminin;
    @FXML
    private Button boutonannuler;

    /**
     * Méthode pour l'enregistrement d'un étudiant.
     * @throws java.lang.Exception
     */
    public void enregistrerEtudiant() throws Exception {
        try {
            char sexe = 'M';
            if (radiomasculin.isSelected()) {
                sexe = 'M';
            } else {
                sexe = 'F';
            }
            if(!txtmatricule.getText().isBlank()) {
                Etudiant etudiant = new Etudiant(Integer.valueOf(txtmatricule.getText()),
                    txtnom.getText(), txtprenom.getText(), datenaissance.getValue(), sexe);
                new EtudiantFacade().enregistrerEtudiant(etudiant);
            } else {
                System.out.println("Matricule null");
            }
            txtmatricule.setText("");
            txtnom.setText("");
            txtprenom.setText("");
            datenaissance.setValue(LocalDate.now());
            radiofeminin.isSelected();
        } catch (NumberFormatException ex) {
            Logger.getLogger(enregistrerControleur.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }

    /**
     * Méthode exécutée lors de l'initialisation de l'objet.
     *
     * @param url URL
     * @param rb ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup groupeRadio = new ToggleGroup();
        radiomasculin.setToggleGroup(groupeRadio);
        radiofeminin.setToggleGroup(groupeRadio);
        radiomasculin.isFocused();
        radiomasculin.isSelected();
        datenaissance.setValue(LocalDate.now());
    }
    /**
     * Méthode pour annuler les informations saisies.
     */
    public void annulerEnregistrement() {
        txtmatricule.setText("");
        txtnom.setText("");
        txtprenom.setText("");
        datenaissance.setValue(LocalDate.now());
        radiofeminin.isSelected();
    }

}
