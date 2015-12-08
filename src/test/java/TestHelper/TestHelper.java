package TestHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tom on 03.12.2015.
 */
public class TestHelper {

    private static final String DATE_FORMAT = "dd.MM.yyyy";


    public static Date toDate(String ddMMyyyy) throws ParseException {
        return new SimpleDateFormat(DATE_FORMAT).parse(ddMMyyyy);
    }
}
