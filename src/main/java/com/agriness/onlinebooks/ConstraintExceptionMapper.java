package com.agriness.onlinebooks;


import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.agriness.onlinebooks.dto.ErrorMessageDTO;

import java.util.stream.Collectors;

@Provider
public class ConstraintExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<ConstraintViolationException>  {

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