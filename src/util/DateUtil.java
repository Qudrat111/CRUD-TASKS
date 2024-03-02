package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static String formatDate(LocalDateTime dateTime){
        if(dateTime == null) return null;
        return DATE_TIME_FORMATTER.format(dateTime);
    }
}
