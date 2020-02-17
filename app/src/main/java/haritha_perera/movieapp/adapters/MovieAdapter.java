package haritha_perera.movieapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import haritha_perera.movieapp.R;
import haritha_perera.movieapp.databinding.MovieItemsBinding;
import haritha_perera.movieapp.models.MovieSearch;
import haritha_perera.movieapp.models.Movies;


import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemViewHolder> {

    private ArrayList<MovieSearch> movieArrayList;


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemsBinding employeeListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.movie_items, parent, false);
        return new ItemViewHolder(employeeListItemBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        MovieSearch currentItem = movieArrayList.get(position);
        holder.movieItemsBinding.setMovie(currentItem);
    }


    @Override
    public int getItemCount() {
        if(movieArrayList != null){
            return movieArrayList.size();
        }else {
            return 0;
        }
    }



    public void setMovieList(ArrayList<MovieSearch> movieArrayList) {
        this.movieArrayList = movieArrayList;
        notifyDataSetChanged();
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private MovieItemsBinding movieItemsBinding;


        public ItemViewHolder(MovieItemsBinding employeeListItemBinding) {
            super(employeeListItemBinding.getRoot());
            this.movieItemsBinding = employeeListItemBinding;
        }
    }
}
