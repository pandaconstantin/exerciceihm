/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bf.esiupb.controleur;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Constantin DRABO
 */
public class principaleControleur {
    
    private Stage fenetreEnregistrer;
    private Stage fenetrePrincipale;
    private Stage fenetreLister;
    @FXML
    private AnchorPane paneprincipal;
    public void afficherEnregistrer() {
        try {
            Parent racineFenetreEnregistrer = FXMLLoader.load(getClass()
                    .getResource("/bf/esiupb/vue/enregistrer.fxml"));
            Scene sceneEnregistrer = new Scene(racineFenetreEnregistrer);
            fenetreEnregistrer = new Stage();
            fenetreEnregistrer.setScene(sceneEnregistrer);
            fenetreEnregistrer.initModality(Modality.WINDOW_MODAL);
            fenetreEnregistrer.setResizable(false);
            //J'obtient la fenetre principale à partir du controleur.
            fenetrePrincipale = new Stage();
            fenetrePrincipale = (Stage) paneprincipal.getScene().getWindow();
            fenetreEnregistrer.initOwner(fenetrePrincipale);
            fenetreEnregistrer.show();
        } catch (IOException ex) {
            Logger.getLogger(principaleControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void afficherLister() {
        try {
            Parent racineFenetreLister = FXMLLoader.load(getClass()
                    .getResource("/bf/esiupb/vue/lister.fxml"));
            Scene sceneLister = new Scene(racineFenetreLister);
            fenetreLister = new Stage();
            fenetreLister.setScene(sceneLister);
            fenetreLister.initModality(Modality.WINDOW_MODAL);
            fenetreLister.setResizable(false);
            fenetrePrincipale = new Stage();
            fenetrePrincipale = (Stage) paneprincipal.getScene().getWindow();
            fenetreLister.initOwner(fenetrePrincipale);
            fenetreLister.show();
        } catch (IOException ex) {
            Logger.getLogger(principaleControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void quitterApplication() {
        //Quitter l'application
        Platform.exit();
    }
    
}
