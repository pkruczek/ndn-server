package pl.edu.agh.sm.ndn;

import io.vavr.control.Try;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.named_data.jndn.Name;
import pl.edu.agh.sm.weather.WeatherService;

/**
 * Handles
 * /ndn/agh/weather/{city}/{unix_time}
 */

@RequiredArgsConstructor
public class NdnWeatherController {

    private final WeatherService weatherService;

    public NdnResponse processRequest(Name name) {
        return Try.of(() -> WeatherParameters.of(name))
                .flatMap(params -> weatherService.getWeather(params.getCity(), params.getTime()))
                .map(NdnResponse::ok)
                .getOrElseGet(error -> NdnResponse.error(error.getMessage()));
    }

    @Data
    private static class WeatherParameters {
        private final String city;
        private final long time;

        static WeatherParameters of(Name prefix) {
            String city = prefix.get(3).toEscapedString();
            long time = Long.parseLong(prefix.get(4).toEscapedString());
            return new WeatherParameters(city, time);
        }
    }
}
