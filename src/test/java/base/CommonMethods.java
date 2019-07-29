package base;

import configurations.RequestConfigurations;
import enums.SpellerLanguages;
import enums.SpellerOptions;
import io.restassured.response.Response;
import steps.AssertionSteps;

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

    public static AssertionSteps commonAssertionForText(Response response) {
        return new AssertionSteps(response)
                .jsonForTextIsNotNull()
                .hasSuccessfulResponse();
    }
}
