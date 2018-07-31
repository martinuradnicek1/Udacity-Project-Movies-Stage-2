package com.example.android.moviesproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

/**
 * Created by martin on 10/03/2018.
 */

public class MovieInfoActivity extends AppCompatActivity {

    final String title = "title";
    final String overview = "overview";
    final String release_date = "release_date";
    final String poster = "poster_path";
    final String vote_average = "vote_average";
    final String max_rating = "/10";

    private TextView titleTextView;
    private TextView releaseDateTextView;
    private TextView overviewTextView;
    private TextView voteAverageTextView;
    private ImageView posterImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_info);

        Intent intent = this.getIntent();


        titleTextView = findViewById(R.id.movie_title);
        releaseDateTextView = findViewById(R.id.release_date);
        voteAverageTextView = findViewById(R.id.vote_average);
        overviewTextView = findViewById(R.id.overview);
        posterImageView = findViewById(R.id.poster);


        //If intent contains data, connect them to the views
        if ( intent != null && intent.hasExtra(title)){

            titleTextView.setText(intent.getStringExtra(title));
            releaseDateTextView.setText(intent.getStringExtra(release_date));
            overviewTextView.setText(intent.getStringExtra(overview));
            voteAverageTextView.setText(intent.getStringExtra(vote_average) + max_rating);
            String posterUrl = NetworkUtils.buildMediumPosterUrl(intent.getStringExtra(poster)).toString();
            Picasso.with(this)
                    .load(posterUrl)
                    .into(posterImageView);

            }
        }
    }
