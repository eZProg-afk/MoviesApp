package spiral.movies.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import spiral.movies.Model.Movie;
import spiral.movies.R;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        String title = movie.getTitle();
        String year = movie.getYear();
        String posterURL = movie.getPosterURL();
        holder.textViewTitle.setText(title);
        holder.textViewYear.setText(year);
        Picasso.get()
                .load(posterURL)
                .fit()
                .centerInside()
                .into(holder.imageViewPoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewPoster;
        TextView textViewTitle, textViewYear;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.image_view_poster);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewYear = itemView.findViewById(R.id.text_view_year);
        }
    }
}
