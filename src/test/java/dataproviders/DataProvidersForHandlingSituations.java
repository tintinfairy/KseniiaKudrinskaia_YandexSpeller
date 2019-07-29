package dataproviders;

import org.testng.annotations.DataProvider;

import static enums.SpellerLanguages.RU;
import static enums.SpellerOptions.IGNORE_CAPITALIZATION;
import static enums.SpellerOptions.IGNORE_DIGITS;


public class DataProvidersForHandlingSituations {

    @DataProvider()
    public Object[][] wordsWithDigitsDataProvider() {
        return new Object[][]{
                {RU, IGNORE_DIGITS, "ког34да коалв сле546зла ", "коала"},
                {RU, IGNORE_DIGITS, "вс3тал4о солндце", "солнце"},
                {RU, IGNORE_DIGITS, "синхрофазатрон ст0ит", "синхрофазотрон"}

        };
    }

    @DataProvider()
    public Object[][] wordsWithCapitalsDataProvider() {
        return new Object[][]{
                {RU, IGNORE_CAPITALIZATION, "веДутСя дурожные рАБоты", "дорожные"},
                {RU, IGNORE_CAPITALIZATION, "буДЬТе астарожны ЗдеСь ", "осторожны"},
                {RU, IGNORE_CAPITALIZATION, "нЕ СаДись окрошено", "окрашено"}

        };
    }

}
