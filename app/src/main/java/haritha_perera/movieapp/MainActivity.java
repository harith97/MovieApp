package haritha_perera.movieapp;

import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import haritha_perera.movieapp.adapters.MovieAdapter;
import haritha_perera.movieapp.api.ApiClient;
import haritha_perera.movieapp.api.JsonPlaceHolderApi;
import haritha_perera.movieapp.models.MovieSearch;
import haritha_perera.movieapp.models.Movies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "7153abd9";
    private ArrayList<MovieSearch> list;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static final String KEYWORD_S = "apple"; //searching by keyword apple

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setting Recycler view
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);//increase performance
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //swipe Listener
        swipeRefreshLayout = findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJson(KEYWORD_S);
            }
        });
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);


        onLoadingSwipeRefresh(KEYWORD_S);
    }

    private void onLoadingSwipeRefresh(String keyword){
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                loadJson(keyword);
            }
        });
    }

    public void loadJson(String keyword) {
        swipeRefreshLayout.setRefreshing(true);

        JsonPlaceHolderApi holderApi = ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
        Call<Movies> call = null;

        //search by keyword if want
        if (keyword.length() > 0){
            call = holderApi.getMoviesSearch(keyword, API_KEY);
        }

        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {

                if(response.isSuccessful()&&response.body()!=null){

                    if(!list.isEmpty()){
                        list.clear();
                    }

                    list = response.body().getMovieSearches();

                    adapter = new MovieAdapter(list,MainActivity.this);
                    adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            //Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                            //startActivity(intent);
                        }
                    });

                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
                }else{
                    Log.w("LOG","res"+response.body());

                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(MainActivity.this,"No Articles!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }



}
