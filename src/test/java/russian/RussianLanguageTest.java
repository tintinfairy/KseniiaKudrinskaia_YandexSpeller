package russian;

import base.BaseTest;
import configurations.RequestConfigurations;
import dataproviders.DataProvidersForRussianLanguage;
import enums.SpellerLanguages;
import org.testng.annotations.Test;
import steps.AssertionSteps;

import java.util.List;

import static enums.SpellerOptions.*;

public class RussianLanguageTest extends BaseTest {
    @Test(dataProviderClass = DataProvidersForRussianLanguage.class, dataProvider = "data for sentence check")
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

    @Test(dataProviderClass = DataProvidersForRussianLanguage.class, dataProvider = "data with digits")
    public void ignoreDigitsInWordCheck(SpellerLanguages language, String textToCheck, String expectedText) {
        YANDEX_RESPONSE = RequestConfigurations
                .makeRequest()
                .putLanguage(language)
                .putOptions(IGNORE_DIGITS)
                .putText(textToCheck)
                .allIsSet()
                .sendRequest();

        new AssertionSteps().jsonForOneWordIsNotNull(YANDEX_RESPONSE)
                .hasSuccessfulResponse()
                .wordAssertion(expectedText);

    }

    @Test(dataProviderClass = DataProvidersForRussianLanguage.class, dataProvider = "data with capitals")
    public void ignoreCapitalsInWordCheck(SpellerLanguages language, String textToCheck, String expectedText) {
        YANDEX_RESPONSE = RequestConfigurations
                .makeRequest()
                .putLanguage(language)
                .putOptions(IGNORE_CAPITALIZATION)
                .putText(textToCheck)
                .allIsSet()
                .sendRequest();

        new AssertionSteps().jsonForOneWordIsNotNull(YANDEX_RESPONSE)
                .hasSuccessfulResponse()
                .wordAssertion(expectedText);
    }
}
