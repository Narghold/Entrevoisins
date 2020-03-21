package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


public class FavoriteNeighbourService implements FavoriteApiService {

    private List<Neighbour> favNeighbours;

    public List<Neighbour> getNeighbours() { return favNeighbours; }

    public void addFavNeighbour(Neighbour neighbour){ favNeighbours.add(neighbour); }

    public void removeFavNeighbour(Neighbour neighbour) { favNeighbours.remove(neighbour); }
}
