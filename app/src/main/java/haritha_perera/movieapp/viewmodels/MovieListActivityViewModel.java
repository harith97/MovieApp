package haritha_perera.movieapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import haritha_perera.movieapp.models.MovieSearch;
import haritha_perera.movieapp.repository.MovieRepository;

public class MovieListActivityViewModel extends AndroidViewModel {

    private MovieRepository employeeRepository;
    private static final String KEYWORD_S = "apple"; //searching by keyword apple


    public MovieListActivityViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new MovieRepository();
    }


    public LiveData<List<MovieSearch>> getAllEmployee() {
        return employeeRepository.getMutableLiveData(KEYWORD_S);
    }






}
