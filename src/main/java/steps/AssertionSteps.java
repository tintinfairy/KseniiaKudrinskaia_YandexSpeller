package steps;

import dto.YandexSpellerDto;
import io.restassured.response.Response;
import json.ResponseParser;
import lombok.Getter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertionSteps {
    @Getter
    private List<String> s;
    private YandexSpellerDto yandexSpellerDto;
    private ResponseParser parser;

    public AssertionSteps jsonIsNotNull(Response response) {
        this.yandexSpellerDto = new ResponseParser()
                .getResponseFromJson(response);
        assertThat(yandexSpellerDto).isNotNull();
        return this;
    }

    public AssertionSteps wordAssertion(String expectedWord) {
        assertThat(yandexSpellerDto.getS(), hasItem(expectedWord));
        return this;
    }

}
