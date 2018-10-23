package Weather.Api;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetCityWeather {

    public ArrayList<CityWeather> getCityInformations(int woeid) {
        try {
            retrofit2.Response<CityWeather> response = ApiService.connector().getInfo(woeid).execute();
            if (response != null && response.body() != null) {
                showInformation(new ArrayList<>(Collections.singleton(response.body())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void showInformation(ArrayList<CityWeather> cityWeathers) {
        String minMaxTemp = "";
        String locationType = "";
        String title = "";
        String timeActual = "";
        String sunrise = "";
        String sunset = "";
        String lattLong = "";
        for (CityWeather cityWeather : cityWeathers) {
            minMaxTemp = calculateAverageTemp(cityWeather.getWeathers());
            locationType = cityWeather.getLocationType();
            title = cityWeather.getTitle();
            timeActual = cityWeather.getTime();
            sunrise = cityWeather.getSunRise();
            sunset = cityWeather.getSunSet();
            lattLong = cityWeather.getLattLong();
        }
        String dateTimeSunRise = getDateTimeSunRise(sunrise);
        String dateTimeSunSet = getDateTimeSunSet(sunset);
        String actualTimeDate = getActualTimeDate(timeActual);
        System.out.printf("%s:\t%s\n", locationType, title);
        System.out.printf("Date of sunrise:\t%s\nDate of sunset:\t%s\n", dateTimeSunRise, dateTimeSunSet);
        System.out.printf("Actual date and time:\t%s\n%s\n", actualTimeDate, minMaxTemp);
        System.out.printf("Google Map Link: https://www.google.pl/maps/@%s,15z", lattLong);
    }

    private String getDateTimeSunSet(String sunset) {
        if (sunset != null) {
            return dateAndTimeFormat(sunset);
        }
        return "Couldn't show valid information about sunset.";
    }

    private String getActualTimeDate(String timeActual) {
        if (timeActual != null) {
            return dateAndTimeFormat(timeActual);
        }
        return "Couldn't show valid date and time.";
    }

    private String getDateTimeSunRise(String sunrise) {
        if (sunrise != null) {
            return dateAndTimeFormat(sunrise);
        }
        return "Couldn't show valid information about sunrise.";
    }

    private String dateAndTimeFormat(String timeAndDate) {
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
        DateTime dateTime = fmt.withOffsetParsed().parseDateTime(timeAndDate);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM.dd.yyyy, HH:mm:ss");
        return formatter.print(dateTime);
    }

    private String calculateAverageTemp(List<ConsolidatedWeather> weathers) {
        Double averageMaxTemp = weathers.stream().mapToDouble(ConsolidatedWeather::getMaxTemp).average().getAsDouble();
        Double averageMinTemp = weathers.stream().mapToDouble(ConsolidatedWeather::getMinTemp).average().getAsDouble();
        Double actualTemp = weathers.stream().mapToDouble(ConsolidatedWeather::getTemp).average().getAsDouble();

        return String.format("Average maximum temperature:\t%.2f°C\nAverage minimum temperature:\t%.2f°C\n" +
                "Actual temperature:\t%.2f°C", averageMaxTemp, averageMinTemp, actualTemp);

    }
}
