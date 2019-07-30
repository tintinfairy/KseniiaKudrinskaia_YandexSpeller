package tests;

import base.BaseTest;
import dataproviders.DataProviderForGetTexts;
import enums.SpellerErrors;
import enums.SpellerLanguages;
import enums.SpellerOptions;
import org.testng.annotations.Test;
import steps.ActionSteps;
import steps.AssertionsToSwitch;

import java.util.List;

public class GetCheckTextsTest extends BaseTest {

    @Test(dataProviderClass = DataProviderForGetTexts.class, dataProvider = "wordSentencesDataProvider")
    public void sentenceCheck(SpellerLanguages language, SpellerOptions option, String wordsToCheck, List<String> expectedWords) {

        YANDEX_RESPONSE = ActionSteps.getCheckTexts(language, option, wordsToCheck);
        AssertionsToSwitch.commonAssertionForTexts(YANDEX_RESPONSE)
                .verifyCorrectSentenceIs(expectedWords);
    }

    @Test(dataProviderClass = DataProviderForGetTexts.class, dataProvider = "sentencesWithExpectedErrorCodesDataProvider")
    public void errorCodeCheck(SpellerLanguages language, SpellerOptions option, String wordsToCheck, SpellerErrors error) {

        YANDEX_RESPONSE = ActionSteps.getCheckTexts(language, option, wordsToCheck);
        AssertionsToSwitch.commonAssertionForTexts(YANDEX_RESPONSE)
                .verifyCorrectCodeForTextIs(error);
    }
}
