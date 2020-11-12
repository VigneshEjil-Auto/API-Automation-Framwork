package Test;

import Action.Set_WeatherApi;
import Pojo.PutWeather.Location;
import Pojo.PutWeather.Root;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutWeather {

    @Test
    public void putWeatherApi()
    {
        Set_WeatherApi set = new Set_WeatherApi();
        Root obj =set.SetWeatherApi();

        RequestSpecification spec =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
                addQueryParam("key","qaclick123").
                setContentType(ContentType.JSON).build();
        ResponseSpecification res_spec= new ResponseSpecBuilder().expectStatusCode(200).build();
        new Set_WeatherApi();
        Response res = given().log().all().spec(spec)
              .body(obj)
              .when().post("maps/api/place/add/json")
              .then().spec(res_spec).extract().response();

        String str = res.asString();

        System.out.println(str);
    }
}
