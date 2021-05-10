package com.camp.cammvc.modules.places.service;

import com.camp.cammvc.modules.places.entity.Place;

import java.util.List;

public interface PlaceService {

    public List<Place> getAllPlaces();
    public List<Place> findPlace(long id);
}
