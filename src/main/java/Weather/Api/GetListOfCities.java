package Weather.Api;

import Weather.WeatherInterface;

import java.io.IOException;
import java.util.List;

public class GetListOfCities implements WeatherInterface {
    public void Start() {
        try {
            retrofit2.Response<List<CitiesLocations>> response = ApiService.connector().getCity(new UserInteraction().getCityFromUser()).execute();
            if (response.body() != null && response.body().size() == 0) {
                System.out.println("Nie znaleziono");
                Start();
            }
            displayCities(response.body());
                new UserInteraction().getCityWoeidFromNumber(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayCities(List<CitiesLocations> citiesList) {
        for (int i = 0; i < citiesList.size(); i++) {
            if (i % 4 == 0 && i > 0) {
                System.out.println();
            }
            System.out.format("%1$-5s %2$-25s", i + 1 + ")", citiesList.get(i).getTitleOfCity());
        }

    }
}
