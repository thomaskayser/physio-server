package ch.tkayser.physio.server.patient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Tom on 24.11.15.
 */
@Stateless
public class PatientService {


    @PersistenceContext(name = "physioPU")
    EntityManager em;

    public Patient save(Patient patient) {
        return em.merge(patient);
    }

    public Patient get(Long id) {
        return em.find(Patient.class, id);
    }
}
