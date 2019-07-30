package tests;

import base.BaseTest;
import dataproviders.DataProvidersForAllLanguages;
import dataproviders.DataProvidersForHandlingSituations;
import enums.SpellerErrors;
import enums.SpellerLanguages;
import enums.SpellerOptions;
import org.testng.annotations.Test;
import steps.ActionSteps;
import steps.AssertionsToSwitch;

//[FIXED]
//todo деление на eng и rus старнно и в java и d soapUI. никакой пользы нет - только дублирование кода
public class GetCheckTextTest extends BaseTest {

    @Test(dataProviderClass = DataProvidersForAllLanguages.class, dataProvider = "oneWordDataProvider")
    public void oneWordCheck(SpellerLanguages language, SpellerOptions option, String wordToCheck, String expectedWord) {
        YANDEX_RESPONSE = ActionSteps.getCheckText(language, option, wordToCheck);

        AssertionsToSwitch.commonAssertionForOneWord(YANDEX_RESPONSE)
                .verifyCorrectWordIs(expectedWord);

    }

    @Test(dataProviderClass = DataProvidersForAllLanguages.class, dataProvider = "combinationsWithErrorsDataProvider")
    public void checkingErrorsInResponse(SpellerLanguages language, SpellerOptions option, String wordToCheck, SpellerErrors error) {
        YANDEX_RESPONSE = ActionSteps.getCheckText(language, option, wordToCheck);

        AssertionsToSwitch.commonAssertionForOneWord(YANDEX_RESPONSE)
                .verifyErrorCodeIs(error);
    }

    @Test(dataProviderClass = DataProvidersForHandlingSituations.class, dataProvider = "wordsWithDigitsDataProvider")
    public void ignoreDigitsInWordCheck(SpellerLanguages language, SpellerOptions option, String textToCheck, String expectedText) {
        YANDEX_RESPONSE = ActionSteps.getCheckText(language, option, textToCheck);

        AssertionsToSwitch.commonAssertionForOneWord(YANDEX_RESPONSE)
                .verifyCorrectWordIs(expectedText);

    }

    @Test(dataProviderClass = DataProvidersForHandlingSituations.class, dataProvider = "wordsWithCapitalsDataProvider")
    public void ignoreCapitalsInWordCheck(SpellerLanguages language, SpellerOptions option, String textToCheck, String expectedText) {
        YANDEX_RESPONSE = ActionSteps.getCheckText(language, option, textToCheck);

        AssertionsToSwitch.commonAssertionForOneWord(YANDEX_RESPONSE)
                .verifyCorrectWordIs(expectedText);
    }
}
