package haritha_perera.movieapp.repository;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import haritha_perera.movieapp.MovieListActivity;
import haritha_perera.movieapp.api.ApiClient;
import haritha_perera.movieapp.api.JsonPlaceHolderApi;
import haritha_perera.movieapp.models.MovieSearch;
import haritha_perera.movieapp.models.Movies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class MovieRepository {

    private ArrayList<MovieSearch> employees = new ArrayList<>();
    private MutableLiveData<List<MovieSearch>> mutableLiveData = new MutableLiveData<>();
    private static final String API_KEY = "7153abd9";


    public MovieRepository() {
    }


    public MutableLiveData<List<MovieSearch>> getMutableLiveData(String keyword) {
        JsonPlaceHolderApi holderApi = ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
        Call<Movies> call = null;

        //search by keyword if want
        if (keyword.length() > 0){
            call = holderApi.getMoviesSearch(keyword, API_KEY);
        }

        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                Movies employeeDBResponse = response.body();
                if(response.isSuccessful()&&response.body()!=null){
                    employees =  employeeDBResponse.getMovieSearches();
                    mutableLiveData.setValue(employees);
                }else{
                    // error case
                    /*switch (response.code()) {
                        case 404:
                            Toast.makeText(ErrorHandlingActivity.this, "not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(ErrorHandlingActivity.this, "server broken", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(ErrorHandlingActivity.this, "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }*/
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable throwable) {
                /*if (throwable instanceof HttpException) {
                    Toast.makeText(ErrorHandlingActivity.this, "We had non-2XX http error", Toast.LENGTH_SHORT).show();
                }else if (throwable instanceof IOException) {
                    Toast.makeText(ErrorHandlingActivity.this, "A network or conversion error happened", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ErrorHandlingActivity.this, "network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                }*/

            }
        });

        return mutableLiveData;

    }

}
