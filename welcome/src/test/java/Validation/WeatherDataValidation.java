package Validation;
import Enum.*;
import Pojo.GetWeather.Root;
import org.testng.asserts.SoftAssert;


public class WeatherDataValidation {

    public static void weatherDataValidate(Root response)
    {
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertEquals(response.getId(),WeatherData.id.getCountryCode(),
                "*** Validation Failed ***");
        softAssertion.assertAll();
    }

}
