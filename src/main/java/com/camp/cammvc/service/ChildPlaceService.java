package com.camp.cammvc.service;

import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.entity.ChildPlace;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChildPlaceService {

    public List<ChildPlace> getAllChildPlace();

    public  ResponseEntity<?> registerChildPlace(ChildPlace childPlace,String username,String placeName);

    public  ResponseEntity<?> updateChildPlace(ChildPlace childPlace);

    public  ResponseEntity<?> deleteChildPlace(ChildPlace childPlace);

}
