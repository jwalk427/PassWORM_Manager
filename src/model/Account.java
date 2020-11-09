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

    public String getUsername(){
        return username;
    }

    public String getUrl(){
        return url;
    }

    public String getPassword(){
        return pword.decrypt();
    }

    public String getNotes(){
        return notes;
    }

    public String printAccount() {
        return ("Username: " + username + "  " + "URL: " + url + "  " + "Password: " + pword.decrypt() + "  " + "Notes: " + notes);
    }
}