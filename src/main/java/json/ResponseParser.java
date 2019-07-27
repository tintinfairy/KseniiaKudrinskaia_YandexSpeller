package json;

import com.google.gson.Gson;
import dto.YandexSpellerDto;
import io.restassured.response.Response;

public class ResponseParser {
    private YandexSpellerDto newResponse;

    public YandexSpellerDto getResponceFromJson(Response response) {
        newResponse = new Gson().fromJson(response.asString(), YandexSpellerDto.class);
        return newResponse;
    }

}
