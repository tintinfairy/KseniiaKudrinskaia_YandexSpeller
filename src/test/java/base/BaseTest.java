package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import properties.PropertiesFile;

import java.io.IOException;

public class BaseTest {

    protected String FILE_PATH = "src/test/resources/test.properties";
    protected Response YANDEX_REQUEST;
    protected PropertiesFile propertiesFile;


    @BeforeMethod
    public void setup() throws IOException {
        propertiesFile = new PropertiesFile();
        propertiesFile.createPropertiesFile(FILE_PATH);
        propertiesFile.getValuesFromPropertiesFile();
        RestAssured.baseURI = propertiesFile.getCheckTextEndpoint();
    }

    @AfterMethod
    public void teardown() {
    }


}

