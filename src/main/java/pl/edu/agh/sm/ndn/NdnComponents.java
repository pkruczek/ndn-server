package pl.edu.agh.sm.ndn;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static pl.edu.agh.sm.config.Components.gson;
import static pl.edu.agh.sm.weather.WeatherComponents.weatherService;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NdnComponents {

    private static final NdnSerializer NDN_SERIALIZER = new NdnSerializer(gson());
    private static final NdnWeatherController NDN_WEATHER_CONTROLLER = new NdnWeatherController(weatherService());

    public static NdnWeatherServer newNdnWeatherServer() {
        return new NdnWeatherServer(weatherController(), ndnSerializer());
    }

    private static NdnSerializer ndnSerializer() {
        return NDN_SERIALIZER;
    }

    private static NdnWeatherController weatherController() {
        return NDN_WEATHER_CONTROLLER;
    }

}
