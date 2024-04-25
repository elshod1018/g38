package i18n;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Locale;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private String username;
    private Locale locale;
}
