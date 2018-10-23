package Weather;

import Weather.Api.GetListOfCities;

public class Launch {
    public static void main(String[] args) {
        GetListOfCities getListOfCities = new GetListOfCities();
        getListOfCities.Start();
    }
}

