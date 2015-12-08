package ch.tkayser.physio.abrechnung;

import TestHelper.TestHelper;
import ch.tkayser.physio.server.abrechnung.AbrechnungException;
import ch.tkayser.physio.server.abrechnung.PDFRechnungGenerator;
import ch.tkayser.physio.server.abrechnung.pdfabrechnung.Data;
import ch.tkayser.physio.server.abrechnung.pdfabrechnung.PatientData;
import ch.tkayser.physio.server.abrechnung.pdfabrechnung.Physio;
import ch.tkayser.physio.server.abrechnung.pdfabrechnung.Request;
import ch.tkayser.physio.server.patient.Patient;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.XfaForm;
import org.eclipse.persistence.jaxb.JAXBContext;
import org.eclipse.persistence.jaxb.JAXBMarshaller;
import org.junit.Test;

import javax.xml.bind.JAXB;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.text.ParseException;

/**
 * Created by Tom on 03.12.2015.
 */
public class PDFRechnungGeneratorTest {

    @Test
    public void generatePDF() throws Exception {

        Data data = new Data();
        Request request = new Request();
        data.setRequest(request);
        Physio physio = new Physio();
        request.setPhysio(physio);
        PatientData patient = new PatientData();
        physio.setPatient(patient);

        patient.setName("Name");
        patient.setVorname("Vorname");
        patient.setVorname("Vorname");
        patient.setStrasse("Strasse");


        byte[] bytes = new PDFRechnungGenerator().generatePdf(data);
        FileOutputStream out = new FileOutputStream("RechnungOut.pdf");
        out.write(bytes);
        out.close();

    }

    @Test
    public void doit() throws Exception {
        PdfReader reader = new PdfReader("RechnungTemplate.pdf");
        PdfStamper stamper = new PdfStamper(reader,
                new FileOutputStream("PdfOut.pdf"));

        AcroFields form = stamper.getAcroFields();
        XfaForm xfa = form.getXfa();
        xfa.fillXfaForm(new FileInputStream("abrechnung.xml"));
        stamper.close();
        reader.close();


     }

    @Test
    public void showContent() throws Exception {

        PdfReader reader = new PdfReader("physician_normal_430.pdf");
        XfaForm xfa = new XfaForm(reader);


        String dest = "form.xml";

        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        FileOutputStream os = new FileOutputStream(dest);
        tf.transform(new DOMSource(xfa.getDatasetsNode()), new StreamResult(os));
        reader.close();
        System.out.println(dest);
    }
}
