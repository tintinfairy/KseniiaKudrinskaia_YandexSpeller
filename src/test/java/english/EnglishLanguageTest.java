package english;

import base.BaseTest;
import configurations.RequestConfigurations;
import dataproviders.DataProvidersForEnglishLanguage;
import enums.SpellerErrors;
import enums.SpellerLanguages;
import org.testng.annotations.Test;
import steps.AssertionSteps;

import java.util.List;

import static enums.SpellerOptions.DEFAULT;
//todo деление на eng и rus старнно и в java и d soapUI. никакой пользы нет - только дублирование кода
public class EnglishLanguageTest extends BaseTest {

    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "data for sentence check")
    public void sentenceCheck(SpellerLanguages language, String textToCheck, List<String> expectedWords) {

        YANDEX_RESPONSE = RequestConfigurations
                .makeRequest()
                .putLanguage(language)
                .putOptions(DEFAULT)
                .putText(textToCheck)
                .allIsSet()
                .sendRequest();

        new AssertionSteps().jsonForTextIsNotNull(YANDEX_RESPONSE)
                .hasSuccessfulResponse()
                .textAssertion(expectedWords);
    }


    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "data for one word check")
    public void oneWordCheck(SpellerLanguages language, String wordToCheck, String expectedWord) {


        YANDEX_RESPONSE = RequestConfigurations
                .makeRequest()
                .putLanguage(language)
                .putOptions(DEFAULT)
                .putText(wordToCheck)
                .allIsSet()
                .sendRequest();

        new AssertionSteps().jsonForOneWordIsNotNull(YANDEX_RESPONSE)
                .hasSuccessfulResponse()
                .wordAssertion(expectedWord);

    }

    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "data for checking errors")
    public void checkingErrorsInResponse(SpellerLanguages language, String wordToCheck, SpellerErrors error) {
        YANDEX_RESPONSE = RequestConfigurations
                .makeRequest()
                .putLanguage(language)
                .putOptions(DEFAULT)
                .putText(wordToCheck)
                .allIsSet()
                .sendRequest();

        new AssertionSteps().jsonForOneWordIsNotNull(YANDEX_RESPONSE)
                .hasSuccessfulResponse()
                .errorAssertion(error);
    }
}
