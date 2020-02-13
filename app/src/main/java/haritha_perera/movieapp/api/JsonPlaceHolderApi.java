package haritha_perera.movieapp.api;

import haritha_perera.movieapp.models.Movies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {


    @GET(".")
    Call<Movies> getMoviesSearch(
            @Query("s") String keyword,
            @Query("apiKey") String apiKey
    );

}
