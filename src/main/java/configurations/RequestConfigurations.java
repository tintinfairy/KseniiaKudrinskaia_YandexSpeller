package configurations;

import enums.SpellerLanguages;
import enums.SpellerOptions;
import enums.SpellerRequestParameters;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class RequestConfigurations {

    @Getter
    private static Map<String, String> requestData = new HashMap<>();

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .build();
    }

    public static class RequestBuilder {

        @Getter
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
            requestData = optionsOfRequest;
            return new RequestConfigurations();
        }

    }

    public static RequestBuilder makeRequest() {
        return new RequestBuilder();
    }

    public Response sendRequest() {
        return RestAssured.given(requestSpecification())
                .queryParams(requestData)
                .get();
    }

}
