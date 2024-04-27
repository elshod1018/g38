package i18n;

import java.util.Locale;
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
