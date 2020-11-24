import DataProvider.AddBookDetails;
import DataProvider.GetBookDetails;
import Payload.AddBookData;
import Payload.DeteleBookData;
import Payload.UpdateBook;
import Validation.BasicValidation;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class BookByID {


    @Test
    public  void bookById()
    {
        HashMap<String,String> m = new HashMap<>();
        m.put("name","vigoo");
        m.put("isbn","zxcv");
        m.put("aisle","345687");
        m.put("author","johnson");

        baseURI="http://216.10.245.166/Library/Addbook.php";
        String str1= given()
                .body(m)
                .expect().defaultParser(Parser.JSON)
                .when().post("Library/Addbook.php")
                .then().extract().response().asString();

        System.out.println(str1);

        JsonPath js = new JsonPath(str1);
        String id= js.get("ID");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(js.get("Msg"),"successfully added","Not a success message");
        softAssert.assertAll();
        System.out.println("The confirmation ID is : " + id);

        Response response = given().log().all().queryParams("ID",id)
                .when().get("http://216.10.245.166/Library/GetBook.php")
                .then().extract().response();

        String str =response.asString();
        System.out.println(str);
        BasicValidation.basicValidaation(response);


    }

}



