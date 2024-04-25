package i18n;

import java.util.*;

public class ResourceBundleExample {
    private static List<User> userList = List.of(
            new User("user1", Locale.ENGLISH),
            new User("user2", Locale.forLanguageTag("uz")),
            new User("user3", Locale.FRENCH));

    public static void main(String[] args) {

//        System.out.println(hello);
        System.out.print("Username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        User byUsername = findByUsername(username);

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", byUsername.getLocale());
        String welcome = resourceBundle.getString("welcome");
        System.out.println(welcome);
    }

    public static User findByUsername(String username) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.forLanguageTag("la"));
        String error_message = resourceBundle.getString("error_message");
        return userList.stream().filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(error_message.formatted(username)));
    }
}
