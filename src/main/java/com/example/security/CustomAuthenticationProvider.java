package com.example.security;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.provider.AuthenticationProvider;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;


@Singleton
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public @NonNull AuthenticationResponse authenticate(Object requestContext, @NonNull AuthenticationRequest authRequest) {
        return null;
    }

    @Override
    public @NonNull AuthenticationResponse authenticate(@NonNull AuthenticationRequest authRequest) {
        return AuthenticationProvider.super.authenticate(authRequest);
    }
}
