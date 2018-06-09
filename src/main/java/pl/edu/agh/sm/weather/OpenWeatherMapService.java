package pl.edu.agh.sm.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

interface OpenWeatherMapService {

    String APP_ID = "797c6e6d613309b144e055de25dc7495";
    String BASE_URL = "/data/2.5";

    @GET(BASE_URL + "/weather")
    Call<Map<String, Object>> getWeather(@Query("q") String cityName,
                            @Query("dt") long time,
                            @Query("appid") String appid);

    default Call<Map<String, Object>> getWeather(String cityName, long time) {
        return getWeather(cityName, time, APP_ID);
    }

}
