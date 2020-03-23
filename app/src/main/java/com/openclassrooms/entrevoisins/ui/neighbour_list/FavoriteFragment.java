package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.FavoriteApiService;
import com.openclassrooms.entrevoisins.service.FavoriteNeighbourService;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {

    public static ArrayList<Neighbour> mFavorites;
    private static FavoriteNeighbourService mApiService;
    //private FavoriteApiService mApiService;
    private RecyclerView mRecyclerView;

    MyFavoritesRecyclerViewAdapter mFavoriteAdapter;

    public static FavoriteFragment newInstance() {
        FavoriteFragment fragment = new FavoriteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = (FavoriteNeighbourService) DI.getFavoriteApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_list, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        initList();
        return view;
    }

    private void initList() {
        mFavorites = (ArrayList<Neighbour>) mApiService.getNeighbours();
        mFavoriteAdapter  = new MyFavoritesRecyclerViewAdapter(mFavorites);
        mRecyclerView.setAdapter(mFavoriteAdapter);
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    public static void addFavoriteNeighbour(Neighbour neighbour){
        mApiService.addFavNeighbour(neighbour);
    }

    public static void removeFavoriteNeighbour(Neighbour neighbour){
        mApiService.removeFavNeighbour(neighbour);
    }
}
