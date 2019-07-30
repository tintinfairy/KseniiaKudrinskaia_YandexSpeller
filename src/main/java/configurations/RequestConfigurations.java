package configurations;

import enums.SpellerLanguages;
import enums.SpellerOptions;
import enums.SpellerRequestParameters;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import properties.PropertiesFile;

import java.util.HashMap;
import java.util.Map;

import static enums.UriElements.*;

public class RequestConfigurations extends PropertiesFile {

    private Map<String, String> requestData = new HashMap<>();


    public static RequestSpecification requestSpecificationToGetCheckText() {

        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setBaseUri(HTTPS_SCHEME.getElement() + getEnv() + PATH_CHECK_TEXT.getElement())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static RequestSpecification requestSpecificationToGetCheckTexts() {

        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setBaseUri(HTTPS_SCHEME.getElement() + getEnv() + PATH_CHECK_TEXTS.getElement())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static class RequestBuilder {

        private Map<String, String> optionsOfRequest = new HashMap<>();

        private RequestBuilder() {
        }

        public RequestBuilder putText(String text) {
            optionsOfRequest.put(SpellerRequestParameters.TEXT.getParameters(), text);
            return this;
        }

        public RequestBuilder putLanguage(SpellerLanguages language) {
            optionsOfRequest.put(SpellerRequestParameters.LANGUAGE.getParameters(), language.getLanguage());
            return this;
        }

        public RequestBuilder putOptions(SpellerOptions options) {
            optionsOfRequest.put(SpellerRequestParameters.OPTIONS.getParameters(), options.getOptionCode());
            return this;
        }

        public RequestConfigurations allIsSet() {
            RequestConfigurations requestConfigurations = new RequestConfigurations();
            requestConfigurations.requestData = optionsOfRequest;
            return requestConfigurations;
        }

    }

    public static RequestBuilder makeRequest() {
        return new RequestBuilder();
    }

    public Response sendRequestToGetCheckText() {
        return RestAssured.given(requestSpecificationToGetCheckText())
                .queryParams(requestData)
                .get();
    }

    public Response sendRequestToGetCheckTexts() {
        return RestAssured.given(requestSpecificationToGetCheckTexts())
                .queryParams(requestData)
                .get();
    }

}
