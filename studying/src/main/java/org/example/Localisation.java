package org.example;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Localisation {

    public static void differentWaysToCreateLocale(){
        // using constructor
        Locale loc = new Locale("en", "GB");
        System.out.println(loc.getDisplayCountry() + " " + loc.getDisplayLanguage());

        // using built in constants
        Locale loc2 = Locale.FRANCE;
        System.out.println(loc2.getDisplayCountry() + " " + loc2.getDisplayLanguage());

        // using builder pattern
        Locale loc3 = new Locale.Builder()
                .setLanguage("ar")
                .setRegion("EG")
                .build();
        System.out.println(loc3.getDisplayCountry() + " " + loc3.getDisplayLanguage());
    }

    public static void formatNumbers(){
        double num = 77_000.11;
        System.out.println(NumberFormat.getInstance().format(num)); // default
        System.out.println("China " + NumberFormat.getNumberInstance(Locale.CHINESE).format(num));
        System.out.println("France "+ NumberFormat.getNumberInstance(Locale.FRANCE).format(num));
        System.out.println("Italy " + NumberFormat.getNumberInstance(Locale.ITALY).format(num));
        System.out.println("US " + NumberFormat.getNumberInstance(Locale.US).format(num));
    }

    public static void formatCurrencies(){
        double num = 23.22;
        System.out.println(NumberFormat.getCurrencyInstance().format(num)); // default
        System.out.println("China " + NumberFormat.getCurrencyInstance(Locale.CHINESE).format(num));
        System.out.println("France "+ NumberFormat.getCurrencyInstance(Locale.FRANCE).format(num));
        System.out.println("Italy " + NumberFormat.getCurrencyInstance(Locale.ITALY).format(num));
        System.out.println("US " + NumberFormat.getCurrencyInstance(Locale.US).format(num));
    }

    public static void customFormats(){
        // 0 means insert 0 if we don't have a digit in that position
        // # means leave it out if we don't have a digit in that position
        double num = 77_000.17;
        System.out.println(new DecimalFormat("€#,###,###.#").format(num));
        System.out.println(new DecimalFormat("€0,000,000.0").format(num));
    }
    public static void localisingDates(){
        Locale locUS = new Locale("en", "US");
        Locale locGM = Locale.GERMANY;
        Locale locFrench = Locale.FRANCE;

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Time now: " + localDateTime);

        DateTimeFormatter mediumDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println("US Date: " + mediumDateFormatter.withLocale(locUS).format(localDateTime));
        System.out.println("Germany Date: " +mediumDateFormatter.withLocale(locGM).format(localDateTime));
        System.out.println("France Date: " +mediumDateFormatter.withLocale(locFrench).format(localDateTime));

        DateTimeFormatter shortTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println("US Time: " +shortTimeFormatter.withLocale(locUS).format(localDateTime));
        System.out.println("Germany Time: " +shortTimeFormatter.withLocale(locGM).format(localDateTime));
        System.out.println("France Time: " +shortTimeFormatter.withLocale(locFrench).format(localDateTime));

        DateTimeFormatter mediumDateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println("US Date and Time: " +mediumDateTimeFormatter.withLocale(locUS).format(localDateTime));
        System.out.println("Germany Date and Time: " +mediumDateTimeFormatter.withLocale(locGM).format(localDateTime));
        System.out.println("France Date and Time: " +mediumDateTimeFormatter.withLocale(locFrench).format(localDateTime));

    }
}
