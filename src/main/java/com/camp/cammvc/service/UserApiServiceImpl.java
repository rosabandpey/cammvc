package com.camp.cammvc.service;

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

    public  void register(AppUser appUser)  {

        final String uri="http://localhost:8085/api/authenticate/register";
        String result;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<ResponseApi> response=restTemplate.postForEntity(uri,appUser,ResponseApi.class);
        System.out.println("is successful"+response.getBody().isSuccessfull());
        if(response.getBody().isSuccessfull()) {
            System.out.println("Request Successful");
            System.out.println( response.getBody().getMessage());

        }
        else  {
           // throw new ApiException("Request Failed");

        }

    }

}
