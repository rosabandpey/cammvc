package com.camp.cammvc.exception;

import com.camp.cammvc.entity.ResponseApi;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class MyErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return new DefaultResponseErrorHandler().hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            // handle 5xx errors
            // raw http status code e.g `500`
            System.out.println(response.getRawStatusCode());

            // http status code e.g. `500 INTERNAL_SERVER_ERROR`
            System.out.println(response.getStatusCode());

        }


        else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle 4xx errors
            // raw http status code e.g `404`
            System.out.println(response.getRawStatusCode());

            // http status code e.g. `404 NOT_FOUND`
            System.out.println(response.getStatusCode());


            // get response body
            System.out.println(response.getBody());

            if (response.getStatusCode().value() == HttpStatus.FORBIDDEN.value()) {
                throw new ApiException("rosa forbidden");

            }
        }

    }
}
