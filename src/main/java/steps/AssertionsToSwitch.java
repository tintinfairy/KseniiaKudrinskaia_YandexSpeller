package steps;

import io.restassured.response.Response;

public class AssertionsToSwitch {

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
