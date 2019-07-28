package steps;

import configurations.ResponseConfigurations;
import dto.YandexSpellerDto;
import enums.SpellerErrors;
import io.restassured.response.Response;
import json.ResponseParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class AssertionSteps {

    private YandexSpellerDto yandexSpellerDto;
    private List<YandexSpellerDto> yandexSpellerDtoList;
    private Response response;

    public AssertionSteps jsonForOneWordIsNotNull(Response response) {
        yandexSpellerDto = new ResponseParser()
                .getResponseForOneWordFromJson(response);
        this.response = response;
        assertThat(yandexSpellerDto).isNotNull();
        return this;
    }

    public AssertionSteps jsonForTextIsNotNull(Response response) {
        yandexSpellerDtoList = new ResponseParser()
                .getResponseForTextFromJson(response);
        this.response = response;
        assertThat(yandexSpellerDtoList).isNotNull();
        return this;
    }

    public AssertionSteps hasSuccessfulResponse() {
        response.then().specification(ResponseConfigurations.succesfulResponse());
        return this;
    }

    public AssertionSteps wordAssertion(String expectedWord) {
        assertThat(yandexSpellerDto.getS(), hasItem(expectedWord));
        return this;
    }

    public AssertionSteps textAssertion(List<String> expectedWords) {
        int i = 0;
        for (String word : expectedWords) {
            assertThat(yandexSpellerDtoList.get(i).getS(), hasItem(word));
            i++;
        }

        return this;

    }

    public AssertionSteps errorAssertion(SpellerErrors error) {

        assertThat(String.valueOf(yandexSpellerDto.getCode()), equalToIgnoringCase(error.getErrorCode()));

        return this;
    }
}
