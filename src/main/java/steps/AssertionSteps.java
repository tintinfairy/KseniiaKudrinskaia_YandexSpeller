package steps;

import dto.YandexSpellerDto;
import io.restassured.response.Response;
import json.ResponseParser;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertionSteps {
    private YandexSpellerDto yandexSpellerDto;
    private ResponseParser parser;

    public AssertionSteps jsonIsNotNull(Response response) {
        if (!parser.getResponceFromJson(response).equals(null)) {
            yandexSpellerDto = parser.getResponceFromJson(response);
        }
        return this;
    }

    public AssertionSteps wordAssertion(String expectedWord) {

        assertThat(yandexSpellerDto.getS(), hasItem(expectedWord));
        return this;
    }

}
