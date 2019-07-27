package configurations;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import static configurations.RequestConfigurations.requestSpecification;

public class ResponseConfigurations {

    RequestConfigurations requestConfigurations;
    public static ResponseSpecification succesfulResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification unsuccessfulResponse() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }


}
