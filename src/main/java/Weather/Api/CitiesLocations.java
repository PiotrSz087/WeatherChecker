package Weather.Api;

import com.google.gson.annotations.SerializedName;

public class CitiesLocations {
    @SerializedName("title")
    private String titleOfCity;
    @SerializedName("woeid")
    private Integer woeid;

    public String getTitleOfCity() {
        return titleOfCity;
    }

    public Integer getWoeid() {
        return woeid;
    }
}
