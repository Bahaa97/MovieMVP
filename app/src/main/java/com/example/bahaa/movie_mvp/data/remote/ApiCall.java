package com.example.bahaa.movie_mvp.data.remote;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.bahaa.movie_mvp.callback.OnMovieRetrevierLisener;
import com.example.bahaa.movie_mvp.pojo.MovieRespons;
import com.example.bahaa.movie_mvp.util.Constants;

public class ApiCall {
    public void getMovieData(final OnMovieRetrevierLisener lisener,String movieType){
        AndroidNetworking.get(Constants.BASE_URL+movieType)
                .addQueryParameter(Constants.API_KEY, Constants.API_KEY_VALUE)
                .build()
                .getAsObject(MovieRespons.class, new ParsedRequestListener<MovieRespons>() {


                    @Override
                    public void onResponse(MovieRespons response) {
                        lisener.onSuccess(response.getMovieData());

                    }

                    @Override
                    public void onError(ANError anError) {
                        lisener.onErro(anError.getErrorDetail());
                    }
                });

    }
}
