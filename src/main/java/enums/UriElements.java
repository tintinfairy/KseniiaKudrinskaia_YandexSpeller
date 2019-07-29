package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UriElements {

    HTTPS_SCHEME("https"),
    PATH("/services/spellservice.json/checkText");


    private String element;
}
