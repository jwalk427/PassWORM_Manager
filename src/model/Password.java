package model;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Password implements Serializable {
    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 8955419513388616256L;
    private transient Cipher cipher;
    private SecretKey secretKey;
    private transient KeyGenerator keyGen;
    private byte[] pword;

    public Password(String password) {
        try{
            cipher = Cipher.getInstance("AES");
            keyGen = KeyGenerator.getInstance("AES");
        } catch(Exception e){
            System.out.print("Exception thrown:" + e);
        } finally{
            keyGen.init(256);
            secretKey = keyGen.generateKey();
            try{
                pword = encrypt(password);
            } catch(Exception e){
                System.out.print("Exception thrown:" + e);
            }
        }
    }

    private byte[] encrypt(String message) {
        byte[] encrypted = null;
        try{
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encrypted = cipher.doFinal(message.getBytes());
        } catch(Exception e){
            System.out.print("Exception thrown:" + e);
        }
        return encrypted;
    }

    public String decrypt() {
        String decrypted = "";
        try{
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            decrypted = new String(cipher.doFinal(this.pword), StandardCharsets.UTF_8);
        } catch(Exception e){
            System.out.print("Exception thrown:" + e);
        }
        return decrypted;
    }

    /*Main class for testing and debugging*/
    // public static void main(String[] args)  
    // { 
    //     Password password = new Password("thisispassword");
    //     System.out.println("thisispassword");
    //     System.out.println(password.pword);
    //     System.out.println(password.decrypt(password.pword));
    // } 
}