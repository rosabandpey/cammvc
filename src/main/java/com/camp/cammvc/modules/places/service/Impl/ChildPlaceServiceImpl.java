package com.camp.cammvc.modules.places.service.Impl;

import com.camp.cammvc.modules.places.entity.ChildPlace;
import com.camp.cammvc.entity.ResponseApi;
import com.camp.cammvc.entity.ResponseToken;
import com.camp.cammvc.exception.MyErrorHandler;
import com.camp.cammvc.modules.places.service.ChildPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
        return null;
    }


    @Override
    public ResponseEntity<?> registerChildPlace(ChildPlace childPlace) {

        final String uri = "http://localhost:8085/api/childPlace/savePlace";

        restTemplate.setErrorHandler(new MyErrorHandler());
        Map<String, String> params = new HashMap<String, String>();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity<?> request = new HttpEntity<ChildPlace>(childPlace,headers);
        response = restTemplate.postForEntity(uri, request,ResponseApi.class);
        //response =  restTemplate.exchange(uri,HttpMethod.POST,request,ResponseApi.class);

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
}
