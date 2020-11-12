package Enum;

import java.math.BigDecimal;

public enum WeatherData {
    London_lon(07),
    London_lat(51),
    id(2643743);

    private final int countryCode;
    WeatherData(int countryCode)
    {
        this.countryCode= countryCode;
    }

    public int getCountryCode()
    {
        return countryCode;
    }

}
