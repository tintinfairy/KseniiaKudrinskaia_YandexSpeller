package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.YandexSpellerDto;
import io.restassured.response.Response;

import java.util.List;

public class ResponseParser {
    //[FIXED]
    //todo а зечем тут эта переменная? я пока не вижу вообще ее необъодимости

    //[FIXED]
	/* todo	return ((List<YandexSpellerDto>)new Gson()
				.fromJson(response.asString(), new TypeToken<List<YandexSpellerDto>>() {}.getType()))
			.get(0);*/

    public YandexSpellerDto getResponseForOneWordFromJson(Response response) {
        return ((List<YandexSpellerDto>) new Gson()
                .fromJson(response.asString(), new TypeToken<List<YandexSpellerDto>>() {
                }.getType())).get(0);
    }

    public List<YandexSpellerDto> getResponseForCheckTextsFromJson(Response response) {
        return ((List<List<YandexSpellerDto>>) new Gson()
                .fromJson(response.asString(), new TypeToken<List<List<YandexSpellerDto>>>() {
                }.getType())).get(0);
    }


}
