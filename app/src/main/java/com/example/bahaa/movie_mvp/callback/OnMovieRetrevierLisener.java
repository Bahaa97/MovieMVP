package com.example.bahaa.movie_mvp.callback;

import com.example.bahaa.movie_mvp.pojo.MovieData;

import java.util.List;

public interface OnMovieRetrevierLisener {
    void onSuccess(List<MovieData> movieData);
    void onErro(String msg);
}
