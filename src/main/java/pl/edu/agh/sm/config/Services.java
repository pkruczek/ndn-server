package pl.edu.agh.sm.config;

import pl.edu.agh.sm.weather.WeatherService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Services {

    private static final Retrofit WEATHER_RETROFIT = new Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static WeatherService weatherService() {
        return WEATHER_RETROFIT.create(WeatherService.class);
    }

}
