package model;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = -1386766918084784952L;
    private static User userInstance = null;
    private String userName;
    private String email;
    private Password password;
    private AccountMap accounts;
    
    public static User User(String Username, String Email, String password) 
    { 
        // To ensure only one instance is created 
        if (userInstance == null) 
        { 
            userInstance = new User(Username, Email, password, new AccountMap()); 
        } 
        return userInstance; 
    } 

    public static User User(User user) 
    { 
        // To ensure only one instance is created 
        if (userInstance == null) 
        { 
            userInstance = user; 
        } 
        return userInstance; 
    } 

    public static User getInstance() 
    { 
        return userInstance;
    } 

    public User(String Username, String Email, String pword, AccountMap map) {
        userName = Username;
        email = Email;
        password = new Password(pword);
        accounts = map;
    }

    // public User() {
    //     userName = "default";
    //     email = "default@email.com";
    //     pword = new Password("default");
    //     acctMap = new AccountMap();
    // }

    public String getUserName(){
        return userName;
    }

    public String getEmail(){
        return email;
    }
    
    public void setUserName(String uName) {
    	userName = uName;
    }
    
    public void setEmail(String address) {
    	email = address;
    }

    public boolean confirmPassword(String pass){
        return pass.equals(password.decrypt());
    }

    public void changePassword(String pass){
        password = new Password(pass);
    }

    public void addAccount(String title, String username, String url, String password, String notes) {
        accounts.addAccount(title, username, url, password, notes);
    }

    public void removeAccount(String website){
        accounts.removeAccount(website);
    }

    public void changeAccount(String title, String username, String url, String password, String notes) {
        accounts.changeAccount(title, username, url, password, notes);
    }

    public void printAccounts() {
        accounts.printAccounts();
    }

    public AccountMap getAccounts(){
        return accounts;
    }
    
    public Password getPassword() {
    	return password;
    }
    
    public void setPassword(Password pword) {
    	password = pword;
    }

    /*Main class for testing/Debugging*/
    // public static void main(String[] args) 
    // {
    //     User user = new User("jwalk427", "jwalk427@gmail.com", "password");
    //     user.addAccount("test1", "username", "www.test1.com", "password#1","");
    //     user.addAccount("test2", "username", "www.test2.com", "password#2", "");
    //     user.addAccount("test3", "username", "www.test3.com", "password#3", "");
    //     System.out.println(user.getUserName()+"\n"+user.getEmail());
    //     user.printAccounts();
    //     user.removeAccount("www.test2.com");
    //     user.changeAccount("test3", "username", "www.test3.com", "password#3", "");
    //     System.out.println("_________________________");
    //     user.printAccounts();
    // } 
}