package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

public interface FavoriteApiService{

    /**
     * Get all my Favorite Neighbours
     *
     * @return {@link List}
     */
    static List<Neighbour> getNeighbours() {
        return null;
    }

    /**
     * Add a neighbour to favorites
     * @param neighbour
     */
    void addFavNeighbour(Neighbour neighbour);

    /**
     * Deletes a neighbour from favorites
     * @param neighbour
     */
    void removeFavNeighbour(Neighbour neighbour);
}
