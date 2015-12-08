package ch.tkayser.physio.web.patient;

import ch.tkayser.physio.server.patient.Patient;
import ch.tkayser.physio.server.patient.PatientService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.util.List;

@ManagedBean
@ViewScoped
public class PatientBean {

    @EJB
    private PatientService patientService;

    private List<Patient> patienten;

    private Patient selectedPatient;

    public void findPatients(ActionEvent actionEvent) {
        patienten = patientService.find();
    }

    public List<Patient> getPatienten() {
        return patienten;
    }

    public void setPatienten(List<Patient> patienten) {
        this.patienten = patienten;
    }

    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient selectedPatient) {
        this.selectedPatient = selectedPatient;
    }
}