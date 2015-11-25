package ch.tkayser.physio.patient;

import javafx.scene.shape.PathElement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

/**
 * Created by Tom on 24.11.15.
 */
@Stateless
public class PatientManager {


   public Patient save(Patient patient) {
       return patient;
   }
}
