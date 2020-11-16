package view;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MFA {



   public static String generateCode(){

      Date date = new Date();
      int code = (int)(java.lang.Math.sin(date.getTime()) * 10000);
      code = java.lang.Math.abs(code);

      String ret = code + "";
      while (ret.length() < 5) {
         int digit = java.lang.Math.abs((int)(java.lang.Math.sin(date.getTime()) * 10));
         ret = ret + digit;
      }

      return ret;
   }

   public static void sendEmail(String code, String email) {    

      //If email is empty then goes to Hans's yahoo as default cuz why not
      String to = "hansooms14@yahoo.com";
      if (!email.equals("")) {
        to = email;
      }
      
      String from = "passwormmanager@gmail.com";

      // Get system properties
      Properties props = System.getProperties();

      final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
      // Setup mail server
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "passwormmanager@gmail.com";//
     final String password = "bigolworms";

      // Get the default Session object.
      Session session = Session.getDefaultInstance(props,new Authenticator(){
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }});

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("PassWORM Manager Code");

         // Now set the actual message
         message.setText("Hello,\n\nYour code to log into your PassWORM Manager account is: " + code + "\n\nIf you did not trigger this message, please consider strengthening your password. \n\nThank you,\nPassWORM Team");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}