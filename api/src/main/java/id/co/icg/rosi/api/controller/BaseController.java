package id.co.icg.rosi.api.controller;


import id.co.icg.rosi.api.domain.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BaseController {

    protected ResponseEntity<Response> getHttpStatus(Response response) {
        HttpStatus hs = response.getData() == null ? HttpStatus.BAD_REQUEST :
                HttpStatus.OK;
		return new ResponseEntity<>(response, hs);
	}

    protected ResponseEntity<Response> getHttpStatus(Response response, HttpHeaders headers) {
        HttpStatus hs = response.getData() == null ? HttpStatus.BAD_REQUEST :
                HttpStatus.OK;
        return new ResponseEntity<>(response, headers, hs);
    }
}
