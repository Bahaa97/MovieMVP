package com.example.bahaa.movie_mvp.ui.activity.application;

import android.app.Application;

import com.appizona.yehiahd.fastsave.FastSave;
import com.example.bahaa.movie_mvp.util.Constants;

import java.util.ArrayList;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FastSave.init(getApplicationContext());

        if(!FastSave.getInstance().isKeyExists(Constants.MOVIE_FAV))
            FastSave.getInstance().saveObjectsList(Constants.MOVIE_FAV ,new ArrayList<>());
    }
}
