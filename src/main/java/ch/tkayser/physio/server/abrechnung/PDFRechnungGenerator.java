package ch.tkayser.physio.server.abrechnung;

import ch.tkayser.physio.server.abrechnung.pdfabrechnung.Data;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.XfaForm;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by Tom on 03.12.2015.
 */
public class PDFRechnungGenerator  {

    public byte[] generatePdf(Data data) throws AbrechnungException {


        PdfReader reader = null;
        XfaForm xfa = null;
        try {
            ByteOutputStream out = new ByteOutputStream();
            InputStream vorlage = PDFRechnungGenerator.class.getClassLoader().getResourceAsStream("RechnungTemplate.pdf");
            reader = new PdfReader(vorlage);
            PdfStamper stamper = new PdfStamper(reader, out);

            AcroFields form = stamper.getAcroFields();
            xfa = form.getXfa();

            JAXBContext context = JAXBContext.newInstance(Data.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter xml = new StringWriter();
            marshaller.marshal(data, xml);
            System.out.println(xml.toString());

            xfa.fillXfaForm(new InputSource(new StringReader(xml.toString())));

            stamper.close();
            reader.close();

            return out.getBytes();



        } catch (Exception e) {
            throw new AbrechnungException(e);
        }


    }


 }
