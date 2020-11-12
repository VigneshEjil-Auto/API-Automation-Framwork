package DataProvider;
import org.testng.annotations.DataProvider;

public class GetWeatherForCountry
        {

        @DataProvider(name = "CountryWeather")
        public static Object[][] getData()
         {
        return new Object[][]{  {"London","692bbaff8d7d4449f933a3913fbc4297"},
                                {"France","692bbaff8d7d4449f933a3913fbc4297"},
                                {"spain","692bbaff8d7d4449f933a3913fbc4297"},
                                {"Italy","692bbaff8d7d4449f933a3913fbc4297"},
                                };

        }
        }
