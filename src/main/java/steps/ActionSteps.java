package steps;

import configurations.RequestConfigurations;
import enums.SpellerLanguages;
import enums.SpellerOptions;
import io.restassured.response.Response;

public class ActionSteps {

    public static Response getCheckText(SpellerLanguages language, SpellerOptions option, String textToCheck) {
        return RequestConfigurations
                .makeRequest()
                .putLanguage(language)
                .putOptions(option)
                .putText(textToCheck)
                .allIsSet()
                .sendRequestToGetCheckText();
    }

    public static Response getCheckTexts(SpellerLanguages language, SpellerOptions option, String textToCheck) {
        return RequestConfigurations
                .makeRequest()
                .putLanguage(language)
                .putOptions(option)
                .putText(textToCheck)
                .allIsSet()
                .sendRequestToGetCheckTexts();
    }

}
