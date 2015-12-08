package ch.tkayser.physio.server.abrechnung.pdfabrechnung;

/**
 * Created by Tom on 03.12.2015.
 */
public class PatientData {

    private String name;
    private String vorname;
    private String strasse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
}
