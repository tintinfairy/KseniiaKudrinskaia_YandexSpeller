package dataproviders;

import org.testng.annotations.DataProvider;

import static enums.SpellerLanguages.EN;


public class DataProvidersForEnglishLanguage {

    @DataProvider(name = "data for sentence check")
    public Object[][] englishSentenceDataProvider() {
        return new Object[][]{
                {EN, "hillo drkness mu olf frend", "hello"},
                {EN, "hillo drkness mu olf frend", "darkness"},
                {EN, "hillo drkness mu olf frend", "my"},
                {EN, "hillo drkness mu olf frend", "old"},
                {EN, "hillo drkness mu olf frend", "friend"}
        };
    }

    @DataProvider(name = "data for one word check")
    public Object[][] englishOneWordDataProvider() {
        return new Object[][]{
                {EN, "heu", "hey"},
                {EN, "desr", "dear"},
                {EN, "huw", "how"},
                {EN, "uou", "you"},
                {EN, "felllng", "feeling"}


        };
    }

    @DataProvider(name = "incorrect data")
    public Object[][] englishFailCombinationsDataProvider() {
        return new Object[][]{
                {EN, "буря", "helli"},
                {EN, "crowm", "hope"},
                {EN, "небо", "thinc"}

        };
    }

}
