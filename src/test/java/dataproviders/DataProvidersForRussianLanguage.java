package dataproviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

import static enums.SpellerLanguages.RU;

//todo аналогично с тестами - лучше объединить в идни методы
public class DataProvidersForRussianLanguage {

    @DataProvider(name = "data for sentence check")//todo имя тут вообще опционально,
    // можно прямо по названию метода к нему обращаться в @Test
    public Object[][] russianSentenceDataProvider() {
        List<String> expectedWords = Arrays.asList("здесь", "мало", "места");
        return new Object[][]{
                {RU, "здес малло мнста", expectedWords}
        };
    }

    @DataProvider(name = "data with digits")
    public Object[][] russianWordsWithDigitsDataProvider() {
        return new Object[][]{
                {RU, "ког34да коалв сле546зла ", "коала"},
                {RU, "вс3тал4о солндце", "солнце"},
                {RU, "синхрофазатрон ст0ит", "синхрофазотрон"}

        };
    }

    @DataProvider(name = "data with capitals")
    public Object[][] russianWordsWithCapitalsDataProvider() {
        return new Object[][]{
                {RU, "веДутСя дурожные рАБоты", "дорожные"},
                {RU, "буДЬТе астарожны ЗдеСь ", "осторожны"},
                {RU, "нЕ СаДись окрошено", "окрашено"}

        };
    }

}