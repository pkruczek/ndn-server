package pl.edu.agh.sm.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface WeatherService {

    @GET("/weather")
    Call<Map<String, Object>> getWeather(@Query("q") String cityName);

}
