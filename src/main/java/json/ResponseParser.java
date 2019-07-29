package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.YandexSpellerDto;
import io.restassured.response.Response;
import lombok.Getter;

import java.util.List;

public class ResponseParser {
	@Getter
	private List<YandexSpellerDto> newResponse;//todo а зечем тут эта переменная? я пока не вижу вообще ее необъодимости


	public YandexSpellerDto getResponseForOneWordFromJson(Response response) {
		newResponse = new Gson().fromJson(response.asString(), new TypeToken<List<YandexSpellerDto>>() {
		}.getType());
	/* todo	return ((List<YandexSpellerDto>)new Gson()
				.fromJson(response.asString(), new TypeToken<List<YandexSpellerDto>>() {}.getType()))
			.get(0);*/

		return newResponse.get(0);
	}

	public List<YandexSpellerDto> getResponseForTextFromJson(Response response) {
		newResponse = new Gson().fromJson(response.asString(), new TypeToken<List<YandexSpellerDto>>() {
		}.getType());
		return newResponse;
	}


}
