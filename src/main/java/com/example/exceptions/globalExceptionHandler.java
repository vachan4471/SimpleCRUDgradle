package com.example.exceptions;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;

@Produces
@Singleton
public class globalExceptionHandler implements ExceptionHandler<Exception,HttpResponse<errorResponse>> {

    @Override
    public HttpResponse<errorResponse> handle(HttpRequest request, Exception exception) {
        if(exception instanceof EntityNotFoundException enf){
            new errorResponse("404", enf.getMessage(), request.getPath());
        }

        return HttpResponse.serverError(
                new errorResponse("500",exception.getMessage(), request.getPath())
        );
    }
}
