package Validation;

import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

public class BasicValidation {

    public static void basicValidaation(Response response){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertAll();
    }


}
