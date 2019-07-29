package dataproviders;

import org.testng.annotations.DataProvider;

import static enums.SpellerErrors.ERROR_UNKNOWN_WORD;
import static enums.SpellerLanguages.EN;
import static enums.SpellerOptions.DEFAULT;

//[FIXED]
//todo аналогично с тестами - лучше объединить в идни методы
public class DataProvidersForAllLanguages {

    //[FIXED]
    //todo имя тут вообще опционально,
    // можно прямо по названию метода к нему обращаться в @Test
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