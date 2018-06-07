package pl.edu.agh.sm;

import pl.edu.agh.sm.config.Services;
import pl.edu.agh.sm.weather.WeatherService;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        WeatherService weatherService = Services.weatherService();
        String url = weatherService.getWeather("London").request().url().toString();
        System.out.println(url);
    }

}
