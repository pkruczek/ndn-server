package pl.edu.agh.sm.weather;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WeatherComponents {

    private static final Retrofit WEATHER_RETROFIT = new Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final WeatherService WEATHER_SERVICE = new WeatherService(openWeatherMapService());

    public static WeatherService weatherService() {
        return WEATHER_SERVICE;
    }

    private static OpenWeatherMapService openWeatherMapService() {
        return WEATHER_RETROFIT.create(OpenWeatherMapService.class);
    }

}
