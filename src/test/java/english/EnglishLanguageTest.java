package english;

import base.BaseTest;
import configurations.RequestConfigurations;
import dataproviders.DataProvidersForEnglishLanguage;
import enums.SpellerLanguages;
import org.testng.annotations.Test;
import steps.AssertionSteps;

import static enums.SpellerOptions.DEFAULT;

public class EnglishLanguageTest extends BaseTest {

    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "data for sentence check")
    public void sentenceCheck(SpellerLanguages language, String textToCheck, String expectedText) {
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

        new AssertionSteps().jsonIsNotNull(YANDEX_RESPONSE);
        //.wordAssertion(expectedWord);

    }

    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "incorrect data")
    public void workingWithIncorrectData(SpellerLanguages language, String textToCheck, String expectedText) {

    }
}
