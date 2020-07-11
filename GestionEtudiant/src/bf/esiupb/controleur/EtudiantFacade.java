/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bf.esiupb.controleur;

import bf.esiupb.model.Etudiant;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Constantin Drabo
 */
public class EtudiantFacade {
    private EtudiantJPAFacade etudiantJPAFacade; 
    private EntityManagerFactory emf;

    public EtudiantFacade() {
        emf = Persistence.createEntityManagerFactory("GestionEtudiantPU");
        etudiantJPAFacade = new EtudiantJPAFacade(emf);
    }
    
    public void enregistrerEtudiant(Etudiant etudiant) throws Exception {
        etudiantJPAFacade.create(etudiant);
    }
    
    public List<Etudiant> extraireEtudiants() {
        return etudiantJPAFacade.findEtudiantEntities();
    }
    
}
