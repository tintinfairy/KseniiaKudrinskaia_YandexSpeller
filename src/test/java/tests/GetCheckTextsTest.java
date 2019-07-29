package tests;

import base.BaseTest;
import dataproviders.DataProviderForGetTexts;
import enums.SpellerErrors;
import enums.SpellerLanguages;
import enums.SpellerOptions;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.CommonMethods;

import java.util.List;

public class GetCheckTextsTest extends BaseTest {
    @BeforeClass
    public void setUpURI() {
        RestAssured.baseURI = properties().getCheckTextsEndpoint();
    }

    @Test(dataProviderClass = DataProviderForGetTexts.class, dataProvider = "wordSentencesDataProvider")
    public void sentenceCheck(SpellerLanguages language, SpellerOptions option, String wordsToCheck, List<String> expectedWords) {

        YANDEX_RESPONSE = CommonMethods.getResponse(language, option, wordsToCheck);
        CommonMethods.commonAssertionForTexts(YANDEX_RESPONSE)
                .verifyCorrectSentenceIs(expectedWords);
    }

    @Test(dataProviderClass = DataProviderForGetTexts.class, dataProvider = "sentencesWithExpectedErrorCodesDataProvider")
    public void errorCodeCheck(SpellerLanguages language, SpellerOptions option, String wordsToCheck, SpellerErrors error) {

        YANDEX_RESPONSE = CommonMethods.getResponse(language, option, wordsToCheck);
        CommonMethods.commonAssertionForTexts(YANDEX_RESPONSE)
                .verifyCorrectCodeForTextIs(error);
    }
}
