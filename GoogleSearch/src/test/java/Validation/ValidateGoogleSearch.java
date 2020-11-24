package Validation;

import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

public class ValidateGoogleSearch {

    public static void validateGoogleSearch(Response response)
    {
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(response.statusCode(),200,"Wrong status code");
        softassert.assertEquals(response.getContentType(),"application/json; charset=UTF-8",
                "Wrong Content Type");
        softassert.assertAll();
    }
}
