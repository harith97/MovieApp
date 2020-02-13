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
import haritha_perera.movieapp.models.MovieSearch;
import haritha_perera.movieapp.models.Movies;


import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemViewHolder> {

    private ArrayList<MovieSearch> movieArrayList;
    private OnItemClickListener onItemClickListener;
    private Context context;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_items,parent,false);
        return new ItemViewHolder(view,  onItemClickListener);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        MovieSearch currentItem = movieArrayList.get(position);

        RequestOptions requestOptions = new RequestOptions();
        //requestOptions.placeholder(Utils.getRandomDrawbleColor());
        //requestOptions.error(Utils.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();

        Glide.with(context)
                .load(currentItem.getPoster())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.imageView);

        holder.title.setText( currentItem.getTitle());
        holder.type.setText( currentItem.getType());
        holder.year.setText( currentItem.getYear());


    }


    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public MovieAdapter(ArrayList<MovieSearch> movieArrayList, Context context){
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    public void  setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView title,year,type;
        public ImageView imageView;
        public ProgressBar progressBar;

        public ItemViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);
            type = itemView.findViewById(R.id.type);
            imageView = itemView.findViewById(R.id.img);
            progressBar = itemView.findViewById(R.id.progressBar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            listener.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
