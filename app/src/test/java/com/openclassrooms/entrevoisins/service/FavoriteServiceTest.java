package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Favorite service
 */
@RunWith(JUnit4.class)
public class FavoriteServiceTest {

    private FavoriteNeighbourService favoriteApiService;
    private DummyNeighbourApiService neighbourApiService;


    @Before
    public void setup() {
        favoriteApiService = (FavoriteNeighbourService) DI.getNewInstanceFavoriteApiService();
        neighbourApiService = (DummyNeighbourApiService) DI.getNewInstanceApiService();
    }

    @Test
    public void getFavoriteWithSuccess() {
        List<Neighbour> neighbours = favoriteApiService.getNeighbours();
        assertTrue(neighbours.isEmpty());
    }

    @Test
    public void addFavoriteWithSuccess(){
        // Given
        Neighbour neighbourToAdd = neighbourApiService.getNeighbours().get(0);
        // When
        favoriteApiService.addFavNeighbour(neighbourToAdd);
        // Then
        List<Neighbour> neighbours = favoriteApiService.getNeighbours();
        assertThat(neighbours, hasItem(neighbourToAdd));
    }

    @Test
    public void removeFavoriteWithSuccess(){
        // Given
        Neighbour neighbourToRemove = neighbourApiService.getNeighbours().get(0);
        favoriteApiService.addFavNeighbour(neighbourToRemove);
        // When
        favoriteApiService.removeFavNeighbour(neighbourToRemove);
        // Then
        List<Neighbour> neighbours = favoriteApiService.getNeighbours();
        assertTrue(neighbours.isEmpty());
    }
}
