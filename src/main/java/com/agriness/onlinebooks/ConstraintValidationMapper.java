package com.agriness.onlinebooks;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.agriness.onlinebooks.dto.ErrorMessageDTO;



@Provider
public class ConstraintValidationMapper implements ExceptionMapper<ConstraintViolationException>{
	@Override
	public Response toResponse(ConstraintViolationException e) {
	    return Response
	            .status(Response.Status.BAD_REQUEST)
	            .entity( ErrorMessageDTO.build(
	                    e.getConstraintViolations()
	                        .stream()
	                        .map(constraintViolation -> constraintViolation.getMessage())
	                        .collect(Collectors.toList())))
	            .build();
	}

}
