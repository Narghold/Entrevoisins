package com.openclassrooms.entrevoisins.di;

import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.FavoriteApiService;
import com.openclassrooms.entrevoisins.service.FavoriteNeighbourService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

/**
 * Dependency injector to get instance of services
 */
public class DI {

    private static NeighbourApiService service = new DummyNeighbourApiService();
    private static FavoriteApiService favService = new FavoriteNeighbourService();

    /**
     * Get an instance on @{@link NeighbourApiService}
     * @return
     */
    public static NeighbourApiService getNeighbourApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link NeighbourApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static NeighbourApiService getNewInstanceApiService() {
        return new DummyNeighbourApiService();
    }

    public static FavoriteApiService getFavoriteApiService(){ return favService; }

    public static FavoriteApiService getNewInstanceFavoriteApiService(){
        return new FavoriteNeighbourService();
    }
}
