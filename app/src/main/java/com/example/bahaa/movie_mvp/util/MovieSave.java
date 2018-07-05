package com.example.bahaa.movie_mvp.util;

import android.provider.SyncStateContract;

import com.appizona.yehiahd.fastsave.FastSave;
import com.example.bahaa.movie_mvp.pojo.MovieData;

import java.util.List;

public class MovieSave {
    public static boolean isFav(int id){
        List<MovieData> data= FastSave.getInstance().getObjectsList(Constants.MOVIE_FAV,MovieData.class);

        for (MovieData movieData : data) {
            if (movieData.getId() == id){
                return true;
            }

        }
        return false;
    }


    public static void removeFav(int id){
        List<MovieData> data= FastSave.getInstance().getObjectsList(Constants.MOVIE_FAV,MovieData.class);

        for (int i=0;i<data.size();i++) {
            if (data.get(i).getId() == id){
                data.remove(id);
                FastSave.getInstance().saveObjectsList(Constants.MOVIE_FAV,data);
            }

        }


    }

    public static void addFav(MovieData movie){
        List<MovieData> data= FastSave.getInstance().getObjectsList(Constants.MOVIE_FAV,MovieData.class);
        data.add(movie);
        FastSave.getInstance().saveObjectsList(Constants.MOVIE_FAV,data);

    }

}
