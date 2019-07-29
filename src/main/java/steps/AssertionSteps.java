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

    public AssertionSteps(Response response) {
        this.response = response;
    }

    public AssertionSteps jsonForOneWordIsNotNull() {
        yandexSpellerDto = new ResponseParser()
                .getResponseForOneWordFromJson(response);

        //[FIXED]
        // todo не надо тут сетать переменную - это вообщне не visible.
        //сетать ее надо бы в кострукторе,а тут - использовать (это в таком варианте, который ты делаешь)
        assertThat(yandexSpellerDto).isNotNull();
        return this;
    }

    public AssertionSteps jsonForTextsIsNotNull() {
        yandexSpellerDtoList = new ResponseParser()
                .getResponseForCheckTextsFromJson(response);
        assertThat(yandexSpellerDtoList).isNotNull();
        return this;
    }

    public AssertionSteps hasSuccessfulResponse() {
        response.then().specification(ResponseConfigurations.succesfulResponse());
        return this;
    }

    public void verifyCorrectWordIs(String expectedWord) {
        assertThat(yandexSpellerDto.getS(), hasItem(expectedWord));

    }

    public void verifyCorrectSentenceIs(List<String> expectedWords) {
        int i = 0;
        for (String word : expectedWords) {
            assertThat(yandexSpellerDtoList.get(i).getS(), hasItem(word));
            i++;
        }

    }

    public void verifyErrorCodeIs(SpellerErrors error) {
        assertThat(String.valueOf(yandexSpellerDto.getCode()), equalToIgnoringCase(error.getErrorCode()));

        //[FIXED]
//todo личшние строки везде поубирай
    }

    public void verifyCorrectCodeForTextIs(SpellerErrors error) {
        for (int i = 0; i < yandexSpellerDtoList.size(); i++) {
            assertThat(String.valueOf(yandexSpellerDtoList.get(i).getCode()), equalToIgnoringCase(error.getErrorCode()));
        }

    }
}
