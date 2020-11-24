import DataProvider.GetData;
import Validation.ValidateGoogleSearch;
import com.fasterxml.jackson.core.JsonParser;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;


public class GoogleSearch {

    @Test(dataProvider = "GoogleSearchDetails",dataProviderClass = GetData.class)
    public void googleSearchApi(String key, String engine ,String search)
    {
        RestAssured.baseURI="https://www.googleapis.com/customsearch/v1";

        Response res =  given().log().all().queryParams("key",key).
                queryParams("cx",engine).
                queryParams("q",search).expect().defaultParser(Parser.JSON).
                when().get("https://www.googleapis.com/customsearch/v1").
                then().extract().response();

        String str = res.asString();
        //System.out.println(str);
        JsonPath js = new JsonPath(str);
        System.out.println(js.get("kind"));

        ValidateGoogleSearch.validateGoogleSearch(res);

    }
}
