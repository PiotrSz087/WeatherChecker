package Weather.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface WeatherApi {
    @GET("location/search/")
    Call<List<CitiesLocations>> getCity (@Query("query") String city);

    @GET("location/{id}/?format=json")
    Call<CityWeather> getInfo (@Path("id") int woeId);
}
