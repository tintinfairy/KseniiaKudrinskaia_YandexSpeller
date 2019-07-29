package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UriElements {

    HTTPS_SCHEME("https"),
    PATH_CHECK_TEXT("/services/spellservice.json/checkText"),
    PATH_CHECK_TEXTS("/services/spellservice.json/checkTexts");


    private String element;
}
