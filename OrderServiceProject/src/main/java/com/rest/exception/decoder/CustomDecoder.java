package com.rest.exception.decoder;

import java.io.IOException;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.exception.ErrorrResponse;
import com.rest.exception.OrderServiceCustomException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
      ObjectMapper	objectMapper= new ObjectMapper();
      try {
		ErrorrResponse errorrResponse=objectMapper.readValue(response.body().asInputStream(),ErrorrResponse.class);
		return new OrderServiceCustomException(errorrResponse.getMessage(), errorrResponse.getErrorCode());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return new OrderServiceCustomException("ServiceInternalException ","SERVICE_EXCEPTION");
	}

}
