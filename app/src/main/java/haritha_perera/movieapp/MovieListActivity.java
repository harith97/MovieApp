package haritha_perera.movieapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import haritha_perera.movieapp.adapters.MovieAdapter;
import haritha_perera.movieapp.databinding.ActivityMainBinding;
import haritha_perera.movieapp.models.MovieSearch;
import haritha_perera.movieapp.models.Movies;
import haritha_perera.movieapp.viewmodels.MovieListActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private MovieListActivityViewModel movieListActivityViewModel;
    private ActivityMainBinding binding;

    private MovieAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        movieListActivityViewModel = ViewModelProviders.of(this).get(MovieListActivityViewModel.class);


        // bind RecyclerView
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);


        getAllMovies();

        //swipe Listener
        binding.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllMovies();
                binding.swipe.setRefreshing(false);

            }
        });
        binding.swipe.setColorSchemeResources(R.color.colorAccent);


    }

    private void getAllMovies(){
        movieListActivityViewModel.getAllEmployee().observe(this, new Observer<List<MovieSearch>>() {
            @Override
            public void onChanged(@Nullable List<MovieSearch> employees) {
                adapter.setMovieList((ArrayList<MovieSearch>) employees);
            }
        });
    }







}
