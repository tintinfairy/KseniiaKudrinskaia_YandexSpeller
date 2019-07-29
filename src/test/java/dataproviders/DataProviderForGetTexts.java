package dataproviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

import static enums.SpellerErrors.ERROR_UNKNOWN_WORD;
import static enums.SpellerLanguages.EN;
import static enums.SpellerLanguages.RU;
import static enums.SpellerOptions.DEFAULT;

public class DataProviderForGetTexts {
    @DataProvider
    public Object[][] wordSentencesDataProvider() {
        List<String> rusExpectedWords = Arrays.asList("здесь", "мало", "места");
        List<String> enExpectedWords = Arrays.asList("hello", "darkness", "my", "friend");
        return new Object[][]{
                {RU, DEFAULT, "здес малло мнста", rusExpectedWords},
                {EN, DEFAULT, "hillo drkness muy frend", enExpectedWords}
        };
    }

    @DataProvider
    public Object[][] sentencesWithExpectedErrorCodesDataProvider() {
        return new Object[][]{
                {RU, DEFAULT, "здес малло мнста", ERROR_UNKNOWN_WORD},
                {EN, DEFAULT, "hillo drkness muy frend", ERROR_UNKNOWN_WORD}
        };
    }
}
