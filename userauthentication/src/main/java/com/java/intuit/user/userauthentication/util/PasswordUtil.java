package com.java.intuit.user.userauthentication.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

@Component
public class PasswordUtil {
    public String getSalt() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String salt = new String(array, Charset.forName("UTF-8"));

        return salt;
    }


    public String getHash(char[] password, String salt){

        char[] saltedPassword = new char[password.length + salt.length()];
        int idx = 0;
        for(char c : password){
            saltedPassword[idx++] = c;
        }
        for(char c: salt.toCharArray()){
            saltedPassword[idx++] = c;
        }

        CharBuffer charBuffer = CharBuffer.wrap(saltedPassword);

        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
                byteBuffer.position(), byteBuffer.limit());
        Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data


        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = digest.digest(bytes);
        String encoded = Base64.getEncoder().encodeToString(hash);
        System.out.println(encoded);
        return encoded;
    }
}
