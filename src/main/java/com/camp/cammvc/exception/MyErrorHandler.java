package com.camp.cammvc.exception;

import com.camp.cammvc.entity.ResponseApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.*;
import java.nio.file.AccessDeniedException;

public class MyErrorHandler implements ResponseErrorHandler {

    ResponseApi responseApi;
    JSONObject result;

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return new DefaultResponseErrorHandler().hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            // handle 5xx errors
            // raw http status code e.g `500`
            System.out.println("500"+response.getRawStatusCode());

            // http status code e.g. `500 INTERNAL_SERVER_ERROR`
            System.out.println("500"+response.getStatusCode());
            throw new ApiException("Server Error");
        }


        else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle 4xx errors
            // raw http status code e.g `404`
            System.out.println("CLIENT_ERROR"+response.getRawStatusCode());

            // http status code e.g. `404 NOT_FOUND`
            System.out.println("CLIENT_ERROR"+response.getStatusCode());
         // if  (response.getStatusCode()==HttpStatus.FORBIDDEN)
            if (response.getStatusCode()==HttpStatus.NOT_FOUND) {
                        throw new NotFoundException("Not Found");
                   }
            if (response.getStatusCode()==HttpStatus.FORBIDDEN) {
                throw new ApiException("Forbidden Access");
            }
            else {

                BufferedReader bR = new BufferedReader(  new InputStreamReader(response.getBody()));
                String line = "";
                StringBuilder responseStrBuilder = new StringBuilder();
                while((line =  bR.readLine()) != null){

                    responseStrBuilder.append(line);

                }
               
                try {
                    result= new JSONObject(responseStrBuilder.toString());
                    Gson gson = new Gson();
                    responseApi = gson.fromJson(String.valueOf(result), ResponseApi.class); // deserializes json into target2
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                throw new ApiException(responseApi.getMessage());
            }
        }

    }
}
