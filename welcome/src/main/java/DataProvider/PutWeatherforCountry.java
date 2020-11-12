package DataProvider;

import org.testng.annotations.DataProvider;


public class PutWeatherforCountry {

    @DataProvider(name ="PutWeatherData")
    public static Object[][] setData(){

        return new Object[][]{
                             {33.86865878,-38.3434597997,70,"vignesh","4927 avenide de angeline",
                                     "510334444","http://rahulshettyacademy.com","Tamil",} ,
                             {22,-38.3434597997,70,"Ejil","111 avenide de angeline",
                                     "510334444","http://rahulshettyacademy.com","English",}
        };


    }}



