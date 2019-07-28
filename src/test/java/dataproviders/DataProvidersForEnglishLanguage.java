package dataproviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

import static enums.SpellerErrors.ERROR_UNKNOWN_WORD;
import static enums.SpellerLanguages.EN;


public class DataProvidersForEnglishLanguage {

    @DataProvider(name = "data for sentence check")
    public Object[][] englishSentenceDataProvider() {
        List<String> expectedWords = Arrays.asList("hello", "darkness", "my", "friend");
        return new Object[][]{
                {EN, "hillo drkness muy frend", expectedWords}
        };
    }

    @DataProvider(name = "data for one word check")
    public Object[][] englishOneWordDataProvider() {
        return new Object[][]{
                {EN, "towir", "tower"},
                {EN, "guing", "going"},
                {EN, "bigin", "begin"},
                {EN, "uou", "you"},
                {EN, "felllng", "feeling"}


        };
    }

    @DataProvider(name = "data for checking errors")
    public Object[][] englishCombinationsWithErrorsDataProvider() {
        return new Object[][]{
                {EN, "londun", ERROR_UNKNOWN_WORD},
                {EN, "bookk", ERROR_UNKNOWN_WORD},
                {EN, "crowm", ERROR_UNKNOWN_WORD}

        };
    }

}
