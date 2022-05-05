package br.com.globo.desafio.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String localDateTimeToString(final LocalDateTime localDateTime, final String format) {
        if (localDateTime == null) {
            return null;
        }
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }
}
