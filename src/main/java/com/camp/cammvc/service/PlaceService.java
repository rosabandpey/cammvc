package com.camp.cammvc.service;

import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.entity.Place;

import java.util.List;

public interface PlaceService {

    public List<Place> getAllPlaces();
    public List<Place> findPlace(long id);
}
