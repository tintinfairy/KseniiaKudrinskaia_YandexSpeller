package steps;

import configurations.RequestConfigurations;
import enums.SpellerLanguages;
import enums.SpellerOptions;
import io.restassured.response.Response;

public class CommonMethods {

    public static Response getResponse(SpellerLanguages language, SpellerOptions option, String textToCheck) {
        return RequestConfigurations
                .makeRequest()
                .putLanguage(language)
                .putOptions(option)
                .putText(textToCheck)
                .allIsSet()
                .sendRequest();
    }


    public static AssertionSteps commonAssertionForOneWord(Response response) {
        return new AssertionSteps(response)
                .jsonForOneWordIsNotNull()
                .hasSuccessfulResponse();
    }

    public static AssertionSteps commonAssertionForTexts(Response response) {
        return new AssertionSteps(response)
                .jsonForTextsIsNotNull()
                .hasSuccessfulResponse();
    }
}
