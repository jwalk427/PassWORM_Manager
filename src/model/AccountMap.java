package model;

import java.util.HashMap;

public class AccountMap {
    private HashMap<String, Account> acctMap;
    
//Change this to account, map user input title to user, url, account, notes
    public AccountMap() {
        acctMap = new HashMap<String, Account>();
    }
/*Should I return booleans to let the user know
if these methods are successful?*/
    public void addAccount(String title, String username, String url, String password, String notes){
        Account newAcct = new Account(username, url, password, notes);
        acctMap.put(title, newAcct);
    }

    public void removeAccount(String title){
        if(acctMap.containsKey(title)){
            acctMap.remove(title);
        }
    }

    public void changeAccount(String title, String username, String url, String password, String notes){
        if(acctMap.containsKey(title)){
            //Change only those that are not an empty string
            Account oldAcct = acctMap.remove(title);
            if(username.equals("")){
                username = oldAcct.getUsername();
            }
            if(url.equals("")){
                url = oldAcct.getUrl();
            }
            if(password.equals("")){
                password = oldAcct.getPassword();
            }
            if(notes.equals("")){
                notes = oldAcct.getNotes();
            }
            this.addAccount(title, username, url, password, notes);
        }
    }

    public void printAccounts() {
        for(String t : acctMap.keySet()){
            System.out.println(t + ": ");
            acctMap.get(t).printAccount();
        }
    }

    // find by title
    public void getAccount(String title){
        if (acctMap.containsKey(title)){
            acctMap.get(title).printAccount();
        }
    }
}