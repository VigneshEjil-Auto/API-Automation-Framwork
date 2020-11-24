import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Enum.BaseUrlEnum;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class Bin {

    String url = "https://httpbin.org";

    @Test
    public void getID()
    {
        RestAssured.baseURI=url + BaseUrlEnum.getId;

        Response response = given().log().all()
                .when().get("https://httpbin.org/ip")
                .then().extract().response();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 200, "Wrong response code");
        softAssert.assertAll();
    }


    @Test
    public void getUuid()
    {
        RestAssured.baseURI=url + BaseUrlEnum.getUuid;

        Response response = given().log().all()
                .when().get("https://httpbin.org/uuid")
                .then().extract().response();

        if(response!=null)
            System.out.println("Success response ");
        else
            System.out.println("Response is null");

    }

    @Test
    public void postData()
    {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","john");
        map.put("age",30);
        map.put("car",null);


        RestAssured.baseURI=url + BaseUrlEnum.post;

        Response response = given().log().all().body(map)
                .when().post("https://httpbin.org/post")
                .then().extract().response();
        String str = response.asString();
        System.out.println("The response is :" + str);

    }

    @Test
    public void putData()
    {
        HashMap<String,Object> updatemap = new HashMap<>();
        updatemap.put("value","test");

        RestAssured.baseURI=url + BaseUrlEnum.put;

        Response response = given().log().all().body(updatemap)
                .when().put("https://httpbin.org/put")
                .then().extract().response();

        String str_updated = response.asString();
        System.out.println("The response is :" + str_updated);

    }


}
