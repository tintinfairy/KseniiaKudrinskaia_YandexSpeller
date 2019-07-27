package steps;

import dto.YandexSpellerDto;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertionSteps {
    private YandexSpellerDto yandexSpellerDto;
    private Response response;

    public AssertionSteps wordAssertion(String expectedWord) {
        assertThat(yandexSpellerDto.getS(),hasItem(expectedWord));
        return this;
    }

}
