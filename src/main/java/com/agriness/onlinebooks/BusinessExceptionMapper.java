package com.agriness.onlinebooks;

import java.util.stream.Collectors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.agriness.onlinebooks.dto.ErrorMessageDTO;
import com.agriness.onlinebooks.exception.BusinessException;



@Provider
public class BusinessExceptionMapper  implements javax.ws.rs.ext.ExceptionMapper<BusinessException> {

	@Override
	public Response toResponse(BusinessException exception) {
		return Response
                .status(Response.Status.BAD_REQUEST)
                .entity( ErrorMessageDTO.build(exception.getmessages()))
                .build();
	}

}
