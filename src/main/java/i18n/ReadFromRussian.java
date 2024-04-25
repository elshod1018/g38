package i18n;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ReadFromRussian {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("ru", "RU"));

        String welcome = bundle.getString("welcome");
        String hello = bundle.getString("hello");

        System.out.println("welcome: " + welcome);
        System.out.println("hello: " + hello);

    }

}
