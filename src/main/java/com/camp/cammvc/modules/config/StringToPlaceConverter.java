package com.camp.cammvc.modules.config;


import com.camp.cammvc.modules.places.entity.Place;
import com.camp.cammvc.modules.places.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StringToPlaceConverter implements Converter<String, Place> {

    @Autowired
    private PlaceService placeService;

    @Override
    public Place convert(String s) {
        List<Place> list=placeService.findPlace(Long.valueOf(s));
        System.out.println("list of place"+list.get(0).toString());
        return list.get(0);
    }


}