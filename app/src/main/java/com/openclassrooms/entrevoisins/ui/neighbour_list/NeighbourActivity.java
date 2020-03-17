package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

public class NeighbourActivity extends AppCompatActivity {

    protected final static String BUNDLE_NEIGHBOUR_KEY = "neighbour";
    private TextView mNeighbourName;
    private ImageView mNeighbourAvatar;
    private ImageButton mBackButton;
    private TextView mNeighbourNameInfo;
    private TextView mNeighbourWeb;
    private TextView mNeighbourDescription;
    private FloatingActionButton mFavoriteButton;

    //Lorem Ipsum
    private final static String NEIGHBOUR_DESCRIPTION = "Utque aegrum corpus quassari etiam levibus solet offensis, ita animus eius angustus et tener, quicquid increpuisset, ad salutis suae dispendium existimans factum aut cogitatum, insontium caedibus fecit victoriam luctuosam.";

    //Entrevoisins.com
    private final static String ENTREVOISINS_WEB = "www.entrevoisins.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour);

        //findViewById
        mNeighbourName = findViewById(R.id.neighbour_name);
        mNeighbourAvatar = findViewById(R.id.neighbour_avatar);
        mBackButton = findViewById(R.id.neighbour_back_btn);
        mNeighbourNameInfo = findViewById(R.id.neighbour_name_info);
        mNeighbourWeb = findViewById(R.id.neighbour_web);
        mNeighbourDescription = findViewById(R.id.neighbour_description);
        mFavoriteButton = findViewById(R.id.favorite_btn);

        //Bundle
        Bundle mNeighbourInfo = getIntent().getExtras();
        Neighbour mNeighbour = mNeighbourInfo.getParcelable(BUNDLE_NEIGHBOUR_KEY);
        mNeighbourName.setText(mNeighbour.getName());
        mNeighbourNameInfo.setText(mNeighbour.getName());
        Glide.with(this).load(mNeighbour.getAvatarUrl()).into(mNeighbourAvatar);

        setIcon(mNeighbour);

        //TODO //Faire en sorte de verifier si voisin present dans liste de favoris

        //SetText w/ username
        mNeighbourWeb.setText(ENTREVOISINS_WEB + mNeighbour.getName().toLowerCase());

        //SetText Lorem Ipsum description
        mNeighbourDescription.setText(NEIGHBOUR_DESCRIPTION);

        //OnClickListener
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NeighbourActivity.this.finish();
            }
        });

        mFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mNeighbour.getFavorite()) {
                    mNeighbour.setFavorite(false);
                } else {
                    mNeighbour.setFavorite(true);
                }
                setIcon(mNeighbour);
            }
        });
    }

    //Change Icon
    private void setIcon(Neighbour neighbour){
        if (neighbour.getFavorite()){
            mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
            mFavoriteButton.setColorFilter(Color.rgb(255,215,0));
        }else {
            mFavoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
            mFavoriteButton.setColorFilter(Color.rgb(200, 200, 200));
        }
    }
}
