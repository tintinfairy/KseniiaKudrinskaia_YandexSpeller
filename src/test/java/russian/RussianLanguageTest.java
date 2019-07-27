package russian;

import base.BaseTest;
import dataproviders.DataProvidersForRussianLanguage;
import enums.SpellerLanguages;
import org.testng.annotations.Test;

public class RussianLanguageTest extends BaseTest {
    @Test(dataProviderClass = DataProvidersForRussianLanguage.class, dataProvider = "data for sentence check")
    public void sentenceCheck(SpellerLanguages language, String checkingText, String expectedText) {

    }

    @Test(dataProviderClass = DataProvidersForRussianLanguage.class, dataProvider = "data for one word check")
    public void oneWordCheck (SpellerLanguages language, String checkingText, String expectedText) {

    }
    @Test(dataProviderClass = DataProvidersForRussianLanguage.class, dataProvider = "incorrect data")
    public void workingWithIncorrectData (SpellerLanguages language, String checkingText, String expectedText) {

    }
}
