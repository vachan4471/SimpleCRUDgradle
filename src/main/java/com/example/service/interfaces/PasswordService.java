package com.example.service.interfaces;

public interface PasswordService {
    String encodePassword(String plain);
    boolean verifyPassword(String plain, String hash);
}
