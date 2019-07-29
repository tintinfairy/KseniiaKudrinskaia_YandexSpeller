package tests;

import base.BaseTest;
import base.CommonMethods;
import dataproviders.DataProvidersForAllLanguages;
import dataproviders.DataProvidersForHandlingSituations;
import enums.SpellerErrors;
import enums.SpellerLanguages;
import enums.SpellerOptions;
import org.testng.annotations.Test;

import java.util.List;

//[FIXED]
//todo деление на eng и rus старнно и в java и d soapUI. никакой пользы нет - только дублирование кода
public class AllLanguagesTest extends BaseTest {

    @Test(dataProviderClass = DataProvidersForAllLanguages.class, dataProvider = "sentenceDataProvider")
    public void sentenceCheck(SpellerLanguages language, SpellerOptions option, String textToCheck, List<String> expectedWords) {

        YANDEX_RESPONSE = CommonMethods.getResponse(language, option, textToCheck);

        CommonMethods.commonAssertionForText(YANDEX_RESPONSE)
                .textAssertion(expectedWords);
    }


    @Test(dataProviderClass = DataProvidersForAllLanguages.class, dataProvider = "oneWordDataProvider")
    public void oneWordCheck(SpellerLanguages language, SpellerOptions option, String wordToCheck, String expectedWord) {
        YANDEX_RESPONSE = CommonMethods.getResponse(language, option, wordToCheck);

        CommonMethods.commonAssertionForOneWord(YANDEX_RESPONSE)
                .wordAssertion(expectedWord);

    }

    @Test(dataProviderClass = DataProvidersForAllLanguages.class, dataProvider = "combinationsWithErrorsDataProvider")
    public void checkingErrorsInResponse(SpellerLanguages language, SpellerOptions option, String wordToCheck, SpellerErrors error) {
        YANDEX_RESPONSE = CommonMethods.getResponse(language, option, wordToCheck);

        CommonMethods.commonAssertionForOneWord(YANDEX_RESPONSE)
                .errorAssertion(error);
    }

    @Test(dataProviderClass = DataProvidersForHandlingSituations.class, dataProvider = "wordsWithDigitsDataProvider")
    public void ignoreDigitsInWordCheck(SpellerLanguages language, SpellerOptions option, String textToCheck, String expectedText) {
        YANDEX_RESPONSE = CommonMethods.getResponse(language, option, textToCheck);

        CommonMethods.commonAssertionForOneWord(YANDEX_RESPONSE)
                .wordAssertion(expectedText);

    }

    @Test(dataProviderClass = DataProvidersForHandlingSituations.class, dataProvider = "wordsWithCapitalsDataProvider")
    public void ignoreCapitalsInWordCheck(SpellerLanguages language, SpellerOptions option, String textToCheck, String expectedText) {
        YANDEX_RESPONSE = CommonMethods.getResponse(language, option, textToCheck);

        CommonMethods.commonAssertionForOneWord(YANDEX_RESPONSE)
                .wordAssertion(expectedText);
    }
}
