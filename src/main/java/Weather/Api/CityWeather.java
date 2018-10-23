package Weather.Api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityWeather {
    @SerializedName("consolidated_weather")
    private List<ConsolidatedWeather> weathers;
    @SerializedName("time")
    private String time;
    @SerializedName("sun_rise")
    private String sunRise;
    @SerializedName("sun_set")
    private String sunSet;
    @SerializedName("title")
    private String title;
    @SerializedName("location_type")
    private String locationType;
    @SerializedName("latt_long")
    private String lattLong;
    @SerializedName("timezone")
    private String timezone;

    public List<ConsolidatedWeather> getWeathers() {
        return weathers;
    }

    public String getTime() {
        return time;
    }

    public String getSunRise() {
        return sunRise;
    }

    public String getSunSet() {
        return sunSet;
    }

    public String getTitle() {
        return title;
    }

    public String getLattLong() {
        return lattLong;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getLocationType() {
        return locationType;
    }


}
