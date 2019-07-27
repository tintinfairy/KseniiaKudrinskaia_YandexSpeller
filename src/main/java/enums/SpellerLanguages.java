package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SpellerLanguages {
    EN("en"),
    RU("ru");

    private String language;
}
