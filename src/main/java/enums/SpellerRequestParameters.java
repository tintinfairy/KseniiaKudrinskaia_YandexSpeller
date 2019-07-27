package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SpellerRequestParameters {

    TEXT("text"),
    OPTIONS("options"),
    LANGUAGE("lang");


    private String parameters;
}