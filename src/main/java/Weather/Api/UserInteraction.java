package Weather.Api;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInteraction {
    private Scanner scanner = new Scanner(System.in);

    public String getCityFromUser() {
        System.out.println("Podaj nazwe miasta");
        Pattern pattern = Pattern.compile("[a-zA-z]");
        String word = scanner.nextLine();
        Matcher matcher = pattern.matcher(word);

        if (!matcher.find() || word == null) {
            System.out.println("Bledna nazwa");
            new GetListOfCities().Start();
        }
        return word;
    }

    public void getCityWoeidFromNumber(List<CitiesLocations> citiesList) {
        System.out.println("\nPodaj numer miasta");
        int number = scanner.nextInt();
        if (number > 0 && number <= citiesList.size()) {
            Integer woeid = citiesList.get(number - 1).getWoeid();
            new GetCityWeather().getCityInformations(woeid);
        } else {
            System.out.println("Błedna wartosc");
            getCityWoeidFromNumber(citiesList);
        }

    }
}
