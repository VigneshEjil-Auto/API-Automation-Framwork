package Action;

import DataProvider.GetWeatherForCountry;
import DataProvider.PutWeatherforCountry;
import Pojo.PutWeather.Location;
import Pojo.PutWeather.Root;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Set_WeatherApi {

    public Root SetWeatherApi() {
        Root o = new Root();
        Location loc = new Location();
        List<String> l = new ArrayList<String>();

        loc.setLng(33.86865878);
        loc.setLat(-38.3434597997);
        o.setLocation(loc);
        o.setAccuracy(70);
        o.setName("Ejil");
        o.setAddress("4927 avenide de angeline");
        o.setPhone_number("510334444");
        o.setWebsite("http://rahulshettyacademy.com");
        o.setLanguage("Tamil");
        l.add("shop");
        l.add("mall");
        o.setTypes(l);

        return o;
    }
}
