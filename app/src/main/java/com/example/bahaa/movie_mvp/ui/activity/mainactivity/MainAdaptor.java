package com.example.bahaa.movie_mvp.ui.activity.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bahaa.movie_mvp.R;
import com.example.bahaa.movie_mvp.pojo.MovieData;
import com.example.bahaa.movie_mvp.ui.activity.detailsactivity.DetailsActivity;
import com.example.bahaa.movie_mvp.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdaptor extends RecyclerView.Adapter<MainAdaptor.ViewHolder> {

    private Context context;
    private List<MovieData> list;

    public MainAdaptor(Context context, List<MovieData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Picasso.get()
                .load(Constants.IMG_URL + list.get(position).getPoster_path())
                .into(holder.img);
        holder.movieItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailsActivity.class)
                        .putExtra(Constants.MOVIE_DERAILS,list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_img)
        ImageView img;
        @BindView(R.id.movie_item)
        LinearLayout movieItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
