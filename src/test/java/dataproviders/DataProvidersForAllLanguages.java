package dataproviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

import static enums.SpellerErrors.ERROR_UNKNOWN_WORD;
import static enums.SpellerLanguages.EN;
import static enums.SpellerLanguages.RU;
import static enums.SpellerOptions.DEFAULT;

//[FIXED]
//todo аналогично с тестами - лучше объединить в идни методы
public class DataProvidersForAllLanguages {

    //[FIXED]
    @DataProvider()//todo имя тут вообще опционально,
    // можно прямо по названию метода к нему обращаться в @Test
    public Object[][] sentenceDataProvider() {
        List<String> rusExpectedWords = Arrays.asList("здесь", "мало", "места");
        List<String> enExpectedWords = Arrays.asList("hello", "darkness", "my", "friend");
        return new Object[][]{
                {RU, DEFAULT, "здес малло мнста", rusExpectedWords},
                {EN, DEFAULT, "hillo drkness muy frend", enExpectedWords}
        };
    }


    @DataProvider()
    public Object[][] oneWordDataProvider() {
        return new Object[][]{
                {EN, DEFAULT, "towir", "tower"},
                {EN, DEFAULT, "guing", "going"},
                {EN, DEFAULT, "bigin", "begin"},
                {EN, DEFAULT, "uou", "you"},
                {EN, DEFAULT, "felllng", "feeling"}


        };
    }

    @DataProvider()
    public Object[][] combinationsWithErrorsDataProvider() {
        return new Object[][]{
                {EN, DEFAULT, "londun", ERROR_UNKNOWN_WORD},
                {EN, DEFAULT, "bookk", ERROR_UNKNOWN_WORD},
                {EN, DEFAULT, "crowm", ERROR_UNKNOWN_WORD}

        };
    }

}