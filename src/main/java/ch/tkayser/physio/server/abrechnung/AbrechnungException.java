package ch.tkayser.physio.server.abrechnung;

/**
 * Created by Tom on 03.12.2015.
 */
public class AbrechnungException  extends Exception{
    public AbrechnungException() {
    }

    public AbrechnungException(String message) {
        super(message);
    }

    public AbrechnungException(Throwable cause) {
        super(cause);
    }
}
