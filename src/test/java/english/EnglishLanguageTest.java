package english;

import base.BaseTest;
import dataproviders.DataProvidersForEnglishLanguage;
import enums.SpellerLanguages;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EnglishLanguageTest extends BaseTest {
    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "data for sentence check")
    public void sentenceCheck(SpellerLanguages language, String checkingText, String expectedText) {
    }



    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "data for one word check")
    public void oneWordCheck (SpellerLanguages language, String checkingText, String expectedText) {

    }
    @Test(dataProviderClass = DataProvidersForEnglishLanguage.class, dataProvider = "incorrect data")
    public void workingWithIncorrectData (SpellerLanguages language, String checkingText, String expectedText) {

    }
}
