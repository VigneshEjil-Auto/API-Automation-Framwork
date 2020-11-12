package Test;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class oAuthTest {
    @Test
    public void getOauth()
    {


        String res=given().queryParam("access_token","")
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php").asString();
        System.out.println(res);
    }
}
