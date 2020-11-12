package Test;


import Action.Api_Actions;
import Pojo.GetWeather.Root;
import DataProvider.*;
import Pojo.GetWeather.Weather;
import io.restassured.*;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import java.util.List;


public class GetWeather {

    @Test(dataProvider = "CountryWeather",dataProviderClass = GetWeatherForCountry.class)
    public void getWeatherApi(String country , String key)
    {
        String baseURI ="https://api.openweathermap.org";
        Api_Actions action = new Api_Actions(baseURI);


        Root c=given().queryParam("q", country).queryParam("appid",
                key)
                .expect().defaultParser(Parser.JSON)
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather").as(Root.class);

         action.setExpectedStatusCode(200);


         List<Weather> data = c.getWeather();
           System.out.println(data.get(0).getDescription()); // Method 1
           System.out.println(data.get(0).getIcon());        // Method 1
           System.out.println(c.getWeather().get(0).getId());// Method 2

       // WeatherDataValidation.weatherDataValidate(c);

    }

}
