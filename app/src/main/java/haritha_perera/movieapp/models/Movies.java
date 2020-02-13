package haritha_perera.movieapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movies {


    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<MovieSearch> getMovieSearches() {
        return movieSearches;
    }

    public void setMovieSearches(ArrayList<MovieSearch> movieSearches) {
        this.movieSearches = movieSearches;
    }

    @SerializedName("Response")
    @Expose
    private boolean response;

    @SerializedName("totalResults")
    @Expose
    private int totalResults;

    @SerializedName("Search")
    @Expose
    private ArrayList<MovieSearch> movieSearches;


}
