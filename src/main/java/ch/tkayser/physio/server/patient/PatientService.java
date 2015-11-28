package ch.tkayser.physio.server.patient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Tom on 24.11.15.
 */
@Stateless
public class PatientService {


    @PersistenceContext(name = "physioPU")
    EntityManager em;

    public List<Patient> find() {
        return em.createQuery("Select p FROM Patient p", Patient.class).getResultList();
    }
    public Patient save(Patient patient) {
        return em.merge(patient);
    }

    public Patient get(Long id) {
        return em.find(Patient.class, id);
    }
}
