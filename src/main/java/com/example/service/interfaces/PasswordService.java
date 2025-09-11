package com.example.service;

public interface PasswordService {
    String encodePassword(String plain);
    boolean verifyPassword(String plain, String hash);
}
