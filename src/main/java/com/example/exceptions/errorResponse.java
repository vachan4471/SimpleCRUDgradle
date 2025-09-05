package com.example.exceptions;

public record errorResponse(
    String code,
    String message,
    String path
) {}
