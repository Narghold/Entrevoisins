package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.FavoriteApiService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFavoritesRecyclerViewAdapter extends RecyclerView.Adapter<MyFavoritesRecyclerViewAdapter.ViewHolder> {

    protected List<Neighbour> mFavoriteNeighbour;

    public MyFavoritesRecyclerViewAdapter(List<Neighbour> items) {
        mFavoriteNeighbour = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_favorite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position){
        Neighbour neighbour = mFavoriteNeighbour.get(position);
        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        //Set OnClickListener on Users
        holder.mNeighbourUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bundle
                Bundle neighbourInfo = new Bundle();
                neighbourInfo.putParcelable(NeighbourActivity.BUNDLE_NEIGHBOUR_KEY, neighbour);

                Intent neighbourActivity = new Intent(view.getContext(), NeighbourActivity.class);
                neighbourActivity.putExtras(neighbourInfo);
                view.getContext().startActivity(neighbourActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        //mFavoriteNeighbour  = new ArrayList<>();
        return mFavoriteNeighbour.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_user)
        public ConstraintLayout mNeighbourUser;
        @BindView(R.id.item_list_avatar)
        public ImageView mNeighbourAvatar;
        @BindView(R.id.item_list_name)
        public TextView mNeighbourName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setData(List<Neighbour> data){
        this.mFavoriteNeighbour = data;
        notifyDataSetChanged();
    }
}
