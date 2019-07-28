package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.YandexSpellerDto;
import io.restassured.response.Response;
import lombok.Getter;

import java.util.List;

public class ResponseParser {
    @Getter
    private List<YandexSpellerDto> newResponse;


    public YandexSpellerDto getResponseFromJson(Response response) {
        newResponse = new Gson().fromJson(response.asString(), new TypeToken<List<YandexSpellerDto>>() {
        }.getType());
        return newResponse.get(0);
    }


}
