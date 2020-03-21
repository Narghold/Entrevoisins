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
import com.openclassrooms.entrevoisins.service.FavoriteApiService;

<<<<<<< HEAD:app/src/main/java/com/openclassrooms/entrevoisins/ui/neighbour_list/DetailNeighbourActivity.java
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
=======
>>>>>>> parent of 4ffab77... EventBus:app/src/main/java/com/openclassrooms/entrevoisins/ui/neighbour_list/NeighbourActivity.java
import java.util.List;

public class DetailNeighbourActivity extends AppCompatActivity {

    protected final static String BUNDLE_NEIGHBOUR_KEY = "neighbour";
    private TextView mNeighbourName;
    private ImageView mNeighbourAvatar;
    private TextView mNeighbourNameInfo;
    private FloatingActionButton mFavoriteButton;
    private TextView mNeighbourWeb;
    private TextView mNeighbourDescription;

    private List<Neighbour> mFavNeighbour = FavoriteApiService.getNeighbours();

    //Lorem Ipsum
    private final static String NEIGHBOUR_DESCRIPTION = "Utque aegrum corpus quassari etiam levibus solet offensis, ita animus eius angustus et tener, quicquid increpuisset, ad salutis suae dispendium existimans factum aut cogitatum, insontium caedibus fecit victoriam luctuosam.";
    private final static String ENTREVOISINS_WEB = "www.entrevoisins.com/"; //Entrevoisins.com

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour);

        //findViewById
        mNeighbourName = findViewById(R.id.neighbour_name);
        mNeighbourAvatar = findViewById(R.id.neighbour_avatar);
        ImageButton mBackButton = findViewById(R.id.neighbour_back_btn);
        mNeighbourNameInfo = findViewById(R.id.neighbour_name_info);
        mNeighbourWeb = findViewById(R.id.neighbour_web);
        mNeighbourDescription = findViewById(R.id.neighbour_description);
        mFavoriteButton = findViewById(R.id.favorite_btn);

        //Bundle
        Bundle mNeighbourInfo = getIntent().getExtras();
        assert mNeighbourInfo != null;
        Neighbour mNeighbour = mNeighbourInfo.getParcelable(BUNDLE_NEIGHBOUR_KEY);

        assert mNeighbour != null;
        setNeighbourInfo(mNeighbour);
        setIcon(mNeighbour);

        //TODO Verify if neighbour is in favorite tab

        //OnClickListener
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailNeighbourActivity.this.finish();
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

    /** Set the favorite button with the good icon, resource and ripple
     *
     * @param neighbour
     */
    private void setIcon(Neighbour neighbour){
        if (neighbour.getFavorite()){
            mFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
            mFavoriteButton.setColorFilter(Color.rgb(255,215,0));
            mFavoriteButton.setRippleColor(Color.rgb(200, 200, 200));
        }else {
            mFavoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
            mFavoriteButton.setColorFilter(Color.rgb(200, 200, 200));
            mFavoriteButton.setRippleColor(Color.rgb(255,215,0));
        }
    }

    /** Set neighbour's information in the fields
     *
     * @param neighbour
     */
    private void setNeighbourInfo(Neighbour neighbour){
        mNeighbourName.setText(neighbour.getName());
        mNeighbourNameInfo.setText(neighbour.getName());
        Glide.with(this).load(neighbour.getAvatarUrl()).into(mNeighbourAvatar);
        String webUrl = ENTREVOISINS_WEB + neighbour.getName().toLowerCase();
        mNeighbourWeb.setText(webUrl);
        mNeighbourDescription.setText(NEIGHBOUR_DESCRIPTION);
    }
}
