package base;

import io.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import properties.PropertiesFile;

import java.io.IOException;

public class BaseTest {

    private String FILE_PATH = "src/test/resources/test.properties";
    protected Response YANDEX_RESPONSE;
    private PropertiesFile propertiesFile;


    @BeforeSuite
    public void setup() throws IOException {
        //[FIXED]
        //todo неверно логически перед каждым методом проперти вычитывать.
        //такое должно сетаться один раз в начале.
        // а лучше в PropertiesFile геттер на энв и использовать его в корневых классах вызова метода эндпоинта
        propertiesFile = new PropertiesFile();
        propertiesFile.createPropertiesFile(FILE_PATH);

    }

    protected PropertiesFile properties() {
        if (propertiesFile == null) {
            propertiesFile = new PropertiesFile();
        }
        return propertiesFile;
    }

    @AfterSuite
    public void teardown() {
    }


}

