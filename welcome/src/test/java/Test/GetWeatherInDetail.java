package Test;

import Pojo.GetWeather.Root;
import DataProvider.*;
import io.restassured.*;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;



public class GetWeatherInDetail {

    @Test(dataProvider = "CountryWeather",dataProviderClass = GetWeatherForCountry.class)
    public void getWeatherApi(String country , String key)
    {
        RestAssured.baseURI="https://api.openweathermap.org";
        Root c=given().queryParam("q", country).queryParam("appid",
                key)
                .expect().defaultParser(Parser.JSON)
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather").as(Root.class);

        System.out.println(c.getCoord().getLat() + "\t" + c.getCoord().getLon());
        System.out.println(c.getSys().getCountry()) ;
        System.out.println(c.getName() + "\t" + c.getWind().getSpeed() + "\t" + c.getVisibility());
        System.out.println(c.getWeather().get(0).getDescription());
        System.out.println(c.getMain().getTemp_max() + "\t" + c.getMain().getTemp_min());
        System.out.println("*********************");// use get(index) if you have array

    }


}
