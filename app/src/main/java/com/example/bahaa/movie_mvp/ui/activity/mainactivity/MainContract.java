package com.example.bahaa.movie_mvp.ui.activity.mainactivity;

import com.example.bahaa.movie_mvp.pojo.MovieData;

import java.util.List;

public interface MainContract {
    interface View{
        void viewAdaptar(List<MovieData>data);
        void viewErro(String msg);

    }

    interface Presenter{
        void ondestroy();
    }
}
