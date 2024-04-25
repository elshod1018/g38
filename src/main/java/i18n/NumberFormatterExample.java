package i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class NumberFormatterExample {
    public static void main(String[] args) {
        Locale english = Locale.US;
        Locale uz = Locale.forLanguageTag("uz");
//        numberFormatExample(uz);
//        numberFormatExample(english);

//        currencyFormatExample(english);
//        currencyFormatExample(uz);
//        currencyFormatExample(Locale.CHINA);

        dateFormatExample(english);
        dateFormatExample(uz);
        dateFormatExample(Locale.CHINA);
        dateFormatExample(Locale.FRENCH);
        dateFormatExample(Locale.forLanguageTag("ru"));

    }

    private static void dateFormatExample(Locale english) {
        DateFormat dateInstance = DateFormat.getDateInstance(1, english);
        String formatted = dateInstance.format(new Date());
        System.out.println(formatted);
    }

    private static void currencyFormatExample(Locale english) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(english);
        String formatted = currencyInstance.format(102837.846);
        System.out.println(formatted);
    }

    private static void numberFormatExample(Locale uz) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(uz);
        String formatted = numberFormat.format(1238947830045.763);
        System.out.println(formatted);
    }
}
