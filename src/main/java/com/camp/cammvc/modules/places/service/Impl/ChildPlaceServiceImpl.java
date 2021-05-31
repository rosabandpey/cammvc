package com.camp.cammvc.modules.places.service.Impl;

import com.camp.cammvc.modules.places.entity.ChildPlace;
import com.camp.cammvc.entity.ResponseApi;
import com.camp.cammvc.entity.ResponseToken;
import com.camp.cammvc.exception.MyErrorHandler;
import com.camp.cammvc.modules.places.service.ChildPlaceService;
import com.camp.cammvc.modules.users.entity.AppUser;
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
public class ChildPlaceServiceImpl implements ChildPlaceService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ResponseToken responseToken;

    ResponseEntity<ResponseApi> response;

    @Override
    public List<ChildPlace> getAllChildPlace() {
        final String uri="http://localhost:8085/api/childPlace/findAllPlaces";
        restTemplate.setErrorHandler(new MyErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        response =  restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class);
        List<ChildPlace> places=(response.getBody().getData());

        if (!response.getBody().isSuccessfull()){
            System.out.println( "AllPlace   "+response.getBody().getMessage().toString());
            //  if (response.getStatusCode()==HttpStatus.NOT_FOUND) {
            //      throw new NotFoundException(response.getBody().getMessage());
            //  }
            // throw new ApiException(response.getBody().getMessage());

        }
        else {
            System.out.println( "AllPlace  "+" Child Place List Retrieved Successfully");

        }
        return places;
    }


    @Override
    public ResponseEntity<?> registerChildPlace(ChildPlace childPlace) {

        final String uri = "http://localhost:8085/api/childPlace/savePlace";

        restTemplate.setErrorHandler(new MyErrorHandler());
        Map<String, String> params = new HashMap<String, String>();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity<?> request = new HttpEntity<>(childPlace, headers);
        response = restTemplate.postForEntity(uri, request,ResponseApi.class);

        if (!response.getBody().isSuccessfull()){

            System.out.println( "register   "+response.getBody().getMessage().toString());
            //    throw new ApiException(response.getBody().getMessage());
        }
        else {
            System.out.println( "register   "+"Place Registered Successfully");
        }
        return response;
    }

    @Override
    public ResponseEntity<?> updateChildPlace(ChildPlace childPlace) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteChildPlace(ChildPlace childPlace) {
        return null;
    }

    @Override
    public ChildPlace findChildPlaceById(long id) {
        final String uri = "http://localhost:8085/api/childPlace/findPlaceById/{id}";
        restTemplate.setErrorHandler(new MyErrorHandler());
       // Map<String, Long> params = new HashMap<String, Long>();
       // params.put("id",id);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<ChildPlace> response =  restTemplate.exchange(uri, HttpMethod.GET, request, ChildPlace.class,id);
        ChildPlace place = (response.getBody());
        return place;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {

        final String uri="http://localhost:8085/api/childPlace/deletePlace/{id}";
        restTemplate.setErrorHandler(new MyErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        response =  restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class,id);


        if (!response.getBody().isSuccessfull()){
            System.out.println( "Place   "+response.getBody().getMessage().toString());
            //  if (response.getStatusCode()==HttpStatus.NOT_FOUND) {
            //      throw new NotFoundException(response.getBody().getMessage());
            //  }
            // throw new ApiException(response.getBody().getMessage());

        }
        else {
            System.out.println( "Place  "+" Child Place Delete Successfully");

        }
        return response;
    }
}
