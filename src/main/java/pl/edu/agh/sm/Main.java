package pl.edu.agh.sm;

import pl.edu.agh.sm.ndn.NdnComponents;
import pl.edu.agh.sm.ndn.NdnWeatherServer;

public class Main {

    public static void main(String[] args) {
        NdnWeatherServer ndnServer = NdnComponents.newNdnWeatherServer();
//        WeatherService weatherService = Services.weatherService();
//        NdnSerializer ndnSerializer = Services.ndnSerializer();
//        Map<String, Object> data = weatherService.getWeather("Kraków", String.valueOf(new Date().getTime()));
//        System.out.println(ndnSerializer.serialize(NdnResponse.ok(data)));
//        System.out.println(data);
    }

}
