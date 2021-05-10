package com.camp.cammvc.modules.places.service.Impl;

import com.camp.cammvc.modules.places.entity.Place;
import com.camp.cammvc.entity.ResponseApi;
import com.camp.cammvc.entity.ResponseToken;
import com.camp.cammvc.exception.MyErrorHandler;
import com.camp.cammvc.modules.places.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PlaceServiceImpl implements PlaceService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ResponseToken responseToken;

    ResponseEntity<ResponseApi> response;

    @Override
    public List<Place> getAllPlaces() {
        final String uri="http://localhost:8085/api/Places/placeList";
        restTemplate.setErrorHandler(new MyErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        response =  restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class);
        List<Place> places=(response.getBody().getData());

        if (!response.getBody().isSuccessfull()){
            System.out.println( "All Places"+response.getBody().getMessage().toString());
            //  if (response.getStatusCode()==HttpStatus.NOT_FOUND) {
            //      throw new NotFoundException(response.getBody().getMessage());
            //  }
            // throw new ApiException(response.getBody().getMessage());

        }
        else {
            System.out.println( "All Places "+" Place List Retrieved Successfully");

        }
        return places;
    }

    @Override
    public List<Place> findPlace(long id) {
        final String uri="http://localhost:8085/api/Places/findPlace/{id}";
        restTemplate.setErrorHandler(new MyErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        Map<String, Long> params = new HashMap<String, Long>();
        params.put("id", id);
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        response =  restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class,params);
        List<Place> places=(response.getBody().getData());

        if (!response.getBody().isSuccessfull()){
            System.out.println( "Place"+response.getBody().getMessage().toString());
            //  if (response.getStatusCode()==HttpStatus.NOT_FOUND) {
            //      throw new NotFoundException(response.getBody().getMessage());
            //  }
            // throw new ApiException(response.getBody().getMessage());

        }
        else {
            System.out.println( "Places "+" Place Retrieved Successfully");

        }
        return places;
    }




}
