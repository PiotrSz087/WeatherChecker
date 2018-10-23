package Weather.Api;

import com.google.gson.annotations.SerializedName;

public class ConsolidatedWeather {
    @SerializedName("min_temp")
    private double minTemp;
    @SerializedName("max_temp")
    private double maxTemp;
    @SerializedName("the_temp")
    private double temp;
    @SerializedName("weather_state_name")
    private String weatherState;

    public String getWeatherState() {
        return weatherState;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getTemp() {
        return temp;
    }
}
