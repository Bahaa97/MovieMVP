package com.example.bahaa.movie_mvp.ui.activity.mainactivity;

import com.example.bahaa.movie_mvp.callback.OnMovieRetrevierLisener;
import com.example.bahaa.movie_mvp.data.remote.ApiCall;
import com.example.bahaa.movie_mvp.pojo.MovieData;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private ApiCall apiCall;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        apiCall = new ApiCall();
    }

    public void setApator(String movieType) {
        apiCall.getMovieData(new OnMovieRetrevierLisener() {
            @Override
            public void onSuccess(List<MovieData> movieData) {
                view.viewAdaptar(movieData);
            }

            @Override
            public void onErro(String msg) {
                view.viewErro(msg);

            }
        },movieType);

    }

    @Override
    public void ondestroy() {
        view=null;
    }
}
