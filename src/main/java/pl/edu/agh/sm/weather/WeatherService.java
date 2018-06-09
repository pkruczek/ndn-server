package pl.edu.agh.sm.weather;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class WeatherService {

    private final OpenWeatherMapService openWeatherMapService;

    public Try<Map<String, Object>> getWeather(String city, long time) {
        return Try.of(() -> openWeatherMapService.getWeather(city, time)
                .execute()
                .body());
    }

}
