package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class RemoveFavoriteNeighbourEvent {

    public Neighbour neighbour;

    public RemoveFavoriteNeighbourEvent(Neighbour neighbour){ this.neighbour = neighbour;}
}
