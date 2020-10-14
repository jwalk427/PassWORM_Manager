package model;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Password {
    private Cipher cipher;
    private String key;
    private SecretKey secretKey;
    
    public byte[] pword;

    public Password(String password) throws Exception {
        cipher = Cipher.getInstance("AES");
        key = "1234567890123456";
        secretKey = new SecretKeySpec(key.getBytes(), "AES");
        pword = encrypt(password);
    }

    private byte[] encrypt(String message) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(message.getBytes());
        return encrypted;
    }

    public String decrypt(byte[] password) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        String decrypted = new String(cipher.doFinal(password), StandardCharsets.UTF_8);
        return decrypted;
    }

    // public static void main(String[] args) throws Exception 
    // { 
    //     Password password = new Password("thisispassword");
    //     System.out.println("thisispassword");
    //     System.out.println(password.pword);
    //     System.out.println(password.decrypt(password.pword));

    // } 
}