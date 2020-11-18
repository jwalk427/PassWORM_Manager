package model;

import java.io.Serializable;

public class Account implements Serializable {
    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = -7589644695599361599L;
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
    
    public void setUsername(String uName) {
    	this.username = uName;
    }

    public String getUrl(){
        return url;
    }
    
    public void setUrl(String address) {
    	this.url = address;
    }
    
    public Password getPword() {
    	return this.pword;
    }
    
    public void setPword(Password pass) {
    	this.pword = pass;
    }
    
    public void setNotes(String note) {
    	this.notes = note;
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

    public String[] printAccountArray() {
        String[] acctInfo = {username, url, pword.decrypt(), notes};
        return acctInfo;
    }
}