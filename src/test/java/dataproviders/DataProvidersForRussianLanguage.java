package dataproviders;

import org.testng.annotations.DataProvider;

import static enums.SpellerLanguages.RU;


public class DataProvidersForRussianLanguage {

    @DataProvider(name = "data for sentence check")
    public Object[][] russianSentenceDataProvider() {
        return new Object[][]{
                {RU, "здес малм мнста", "здесь"},
                {RU, "здес малм мнста", "мало"},
                {RU,"здес малм мнста", "места"}
        };
    }

    @DataProvider(name = "data for one word check")
    public Object[][] russianOneWordDataProvider() {
        return new Object[][]{
                {RU, "бурья", "буря"},
                {RU, "нглою", "мглою"},
                {RU,"нибо", "небо"},
                {RU,"кройет", "кроет"}

        };
    }
    @DataProvider(name = "incorrect data")
    public Object[][] russianFailCombinationsDataProvider() {
        return new Object[][]{
                {RU, "helli", "буря"},
                {RU, "молю", "мглою"},
                {RU,"thinc", "небо"}

        };
    }

}