package com.example.bahaa.movie_mvp.ui.activity.mainactivity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.appizona.yehiahd.fastsave.FastSave;
import com.example.bahaa.movie_mvp.R;
import com.example.bahaa.movie_mvp.pojo.MovieData;
import com.example.bahaa.movie_mvp.ui.activity.base.BaseActivity;
import com.example.bahaa.movie_mvp.util.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.main_recycle)
    RecyclerView recycle;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    private MainPresenter mainPresenter;
    private MainAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
        mainPresenter.setApator(Constants.POPULER_KEY);
        swipeRefresh.setOnRefreshListener(this);

    }


    @Override
    public void viewAdaptar(List<MovieData> data) {
        recycle.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adaptor = new MainAdaptor(MainActivity.this, data);
        recycle.setAdapter(adaptor);
        if(swipeRefresh.isRefreshing()){
            swipeRefresh.setRefreshing(false);
        }
    }

    @Override
    public void viewErro(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if(swipeRefresh.isRefreshing()){
            swipeRefresh.setRefreshing(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.populer_movie:
                mainPresenter.setApator(Constants.POPULER_KEY);
                return true;
            case R.id.top_rated:
                mainPresenter.setApator(Constants.TOP_RATED_KEY);
                return true;
            case R.id.favourite:
                List<MovieData> data = FastSave.getInstance().getObjectsList(Constants.MOVIE_FAV, MovieData.class);
                adaptor = new MainAdaptor(MainActivity.this, data);
                recycle.setAdapter(adaptor);
                return true;

        }
        return false;
    }

    @Override
    public void onRefresh() {
        mainPresenter.setApator(Constants.POPULER_KEY);
    }
}
