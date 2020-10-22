package model;


public class Account {
    private String username;
    private String url;
    private Password pword;
    private String notes;
    
//Change this to account, map user input title to user, url, password, notes
    public Account(String Username, String Url, String Password, String Notes){
        username = Username;
        url = Url;
        pword = new Password(Password);
        notes = Notes;
    }

    public void printAccount() {
        System.out.println("Username: " + username + "\n" + "URL: " + url + "\n" + "Password: " + pword.decrypt());
        System.out.println("Notes: " + notes);
    }
}