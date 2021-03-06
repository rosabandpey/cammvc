package com.camp.cammvc.modules.places.service.Impl;

import com.camp.cammvc.modules.places.entity.ChildPlace;
import com.camp.cammvc.entity.ResponseApi;
import com.camp.cammvc.entity.ResponseToken;
import com.camp.cammvc.exception.MyErrorHandler;
import com.camp.cammvc.modules.places.service.ChildPlaceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
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
    public Page<ChildPlace> getAllChildPlace(int pageNo) {
        final String uri="http://localhost:8085/api/childPlace/findAllPlaces/{pageNo}";
        restTemplate.setErrorHandler(new MyErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        response =   restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class,pageNo);
        Page<ChildPlace> list=response.getBody().getPage();

        return list;

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
