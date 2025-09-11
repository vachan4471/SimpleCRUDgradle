package com.example.service.Imp;

import com.example.service.PasswordService;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordServiceImp implements PasswordService {
    @Override
    public String encodePassword(String plain) {
        return BCrypt.hashpw(plain,BCrypt.gensalt());
    }

    @Override
    public boolean verifyPassword(String plain, String hash) {
        return hash.equals(encodePassword(plain));
    }
}
