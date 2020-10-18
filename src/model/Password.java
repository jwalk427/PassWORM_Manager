package model;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Password {
    private Cipher cipher;
    private SecretKey secretKey;
    private KeyGenerator keyGen;
    private byte[] pword;

    public Password(String password) throws Exception {
        cipher = Cipher.getInstance("AES");
        keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        secretKey = keyGen.generateKey();
        pword = encrypt(password);
    }

    private byte[] encrypt(String message) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(message.getBytes());
        return encrypted;
    }

    public String decrypt() throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        String decrypted = new String(cipher.doFinal(this.pword), StandardCharsets.UTF_8);
        return decrypted;
    }

    /*Main class for testing and debugging*/
    // public static void main(String[] args) throws Exception 
    // { 
    //     Password password = new Password("thisispassword");
    //     System.out.println("thisispassword");
    //     System.out.println(password.pword);
    //     System.out.println(password.decrypt(password.pword));
    // } 
}