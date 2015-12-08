package ch.tkayser.physio.server.abrechnung.pdfabrechnung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Tom on 03.12.2015.
 */
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Data {

    @XmlElement
    private Request request;


    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
