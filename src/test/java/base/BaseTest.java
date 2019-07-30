package base;

import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import properties.PropertiesFile;

import java.io.IOException;

public class BaseTest extends PropertiesFile {

    private String FILE_PATH = "src/test/resources/test.properties";
    protected Response YANDEX_RESPONSE;

    @BeforeTest
    public void setup() throws IOException {
        //[FIXED]
        //todo неверно логически перед каждым методом проперти вычитывать.
        //такое должно сетаться один раз в начале.
        // а лучше в PropertiesFile геттер на энв и использовать его в корневых классах вызова метода эндпоинта
        createPropertiesFile(FILE_PATH);

    }

    @AfterTest
    public void teardown() {
    }


}

