package com.example.bahaa.movie_mvp.ui.activity.detailsactivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bahaa.movie_mvp.R;
import com.example.bahaa.movie_mvp.pojo.MovieData;
import com.example.bahaa.movie_mvp.ui.activity.base.BaseActivity;
import com.example.bahaa.movie_mvp.util.Constants;
import com.example.bahaa.movie_mvp.util.MovieSave;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {

    @BindView(R.id.img_cover)
    ImageView imgCover;
    @BindView(R.id.poster_img)
    ImageView posterImg;
    @BindView(R.id.movie_title)
    TextView movieTitle;
    @BindView(R.id.movie_review)
    TextView movieReview;
    @BindView(R.id.movie_rate)
    TextView movieRate;
    @BindView(R.id.Movie_fav)
    FloatingActionButton movieFav;
    private MovieData list;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        list = getIntent().getExtras().getParcelable(Constants.MOVIE_DERAILS);
        this.id=list.getId();
        isFav();
        init();

    }

    private void isFav() {
        boolean isFav=MovieSave.isFav(id);
        if(isFav){
            movieFav.setImageResource(R.drawable.yellow_star);
        }else {
            movieFav.setImageResource(R.drawable.white_star);
        }
    }

    private void init() {
        Picasso.get()
                .load(Constants.IMG_URL + list.getBackdrop_path())
                .into(imgCover);
        Picasso.get()
                .load(Constants.IMG_URL + list.getPoster_path())
                .into(posterImg);
        movieTitle.setText(list.getTitle());
        movieReview.setText(list.getOverview());
        movieRate.setText(String.valueOf(list.getVote_average()));
        movieFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isFav=MovieSave.isFav(id);
                if(isFav){
                    MovieSave.removeFav(id);
                    movieFav.setImageResource(R.drawable.white_star);
                }else {
                    movieFav.setImageResource(R.drawable.yellow_star);
                    MovieSave.addFav(list);
                }
            }
        });
    }


}
