package english;

import base.BaseTest;
import configurations.RequestConfigurations;
import configurations.ResponseConfigurations;
import dataproviders.DataProvidersForEnglishLanguage;
import enums.SpellerLanguages;
import org.testng.annotations.Test;
import steps.AssertionSteps;

import static enums.SpellerOptions.DEFAULT;

public class EnglishLanguageTest extends BaseTest {
    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "data for sentence check")
    public void sentenceCheck(SpellerLanguages language, String checkingText, String expectedText) {
    }



    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "data for one word check")
    public void oneWordCheck (SpellerLanguages language, String textToCheck, String expectedText) {

        YANDEX_REQUEST = RequestConfigurations
                .makeRequest()
                .putLanguage(language)
                .putOptions(DEFAULT)
                .putText(textToCheck)
                .allIsSet()
                .sendRequest();

        new AssertionSteps().wordAssertion(expectedText);

    }
    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "incorrect data")
    public void workingWithIncorrectData (SpellerLanguages language, String checkingText, String expectedText) {

    }
}
