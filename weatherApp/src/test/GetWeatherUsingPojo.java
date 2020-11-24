package API_Automation;

import io.restassured.*;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import weather.Root;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonParser;

public class GetWeatherUsingPojo {
	

	public static void main(String args[])
	{
		
		RestAssured.baseURI="https://api.openweathermap.org";
		Root c=given().queryParam("q", "London").queryParam("appid", "692bbaff8d7d4449f933a3913fbc4297")
					.expect().defaultParser(Parser.JSON)
					.when()
					.get("https://api.openweathermap.org/data/2.5/weather").as(Root.class);
		
		System.out.println(c.getCoord().getLat());
		System.out.println(c.getSys().getCountry());
		System.out.println(c.getName());
		System.out.print(c.getWeather().get(0).getDescription());  // use get(index) if you have array
	
		
		
	}

}
