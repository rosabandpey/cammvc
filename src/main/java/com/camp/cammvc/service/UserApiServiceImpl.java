package com.camp.cammvc.service;

import com.camp.cammvc.controller.MyErrorController;
import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.entity.ResponseApi;
import com.camp.cammvc.exception.ApiException;
import com.camp.cammvc.exception.NotFoundException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class UserApiServiceImpl {





    @Autowired
    private RestTemplate restTemplate;



    ResponseEntity<ResponseApi> response;

   /* public ResponseApi getByUsername(String username){
        final String uri="http://localhost:8085/api/authenticate/getByUsername/{username}";
        Map<String,String> params=new HashMap<String,String>();
        params.put("username",username);
        ResponseApi responseApi=restTemplate.getForObject(uri,ResponseApi.class,params);

        if (!responseApi.isSuccessfull()){
            throw new NotFoundException();
        }
        return responseApi;
    }
*/

    public List<AppUser> getAllUsers(){

        final String uri="http://localhost:8085/api/authenticate/userList";
        return Arrays.stream(restTemplate.getForObject(uri, AppUser[].class)).collect(Collectors.toList());
    }




    public  ResponseEntity<?> register(AppUser appUser)  {

           final String uri = "http://localhost:8085/api/authenticate/register";
           restTemplate.setErrorHandler(new MyErrorController());
           response = restTemplate.postForEntity(uri, appUser, ResponseApi.class);
           System.out.println("message" + response.getBody().getMessage());
           if (!response.getBody().isSuccessfull()){
               ResponseApi responseApi=new ResponseApi(response.getBody().isSuccessfull(),response.getBody().getMessage(),response.getBody().getDate(),null);

               throw new ApiException(response.getBody().getMessage());
           }
           return response;




        }





}
