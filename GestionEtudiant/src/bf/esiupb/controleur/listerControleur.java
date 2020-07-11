/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bf.esiupb.controleur;

import bf.esiupb.model.Etudiant;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Constantin DRABO
 */
public class listerControleur implements Initializable {

    @FXML
    TableView<Etudiant> tableauetudiant;
    @FXML
    TableColumn<Etudiant, Integer> colmatricule;
    @FXML
    TableColumn<Etudiant, String> colnom;
    @FXML
    TableColumn<Etudiant, String> colprenom;
    @FXML
    TableColumn<Etudiant, LocalDate> coldatenaissance;
    @FXML
    TableColumn<Etudiant, Character> colsexe;
    EtudiantFacade etudiantFacade;
    List<Etudiant> listeEtudiants;
    /**
     * Méthode executée lors de l'initialisation de l'objet.
     * @param url URL
     * @param rb ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colmatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        coldatenaissance.setCellValueFactory(new PropertyValueFactory<>("dateNaissaince"));
        colsexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        etudiantFacade = new EtudiantFacade();
        listeEtudiants = new ArrayList<>();
        listeEtudiants = etudiantFacade.extraireEtudiants();
        ObservableList<Etudiant> etudiants = FXCollections.observableList(listeEtudiants);
        tableauetudiant.setItems(etudiants);
    }

}
