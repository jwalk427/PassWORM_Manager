package model;

import java.util.HashMap;

public class PasswordMap {
    private HashMap<String, Password> pwordMap;
    

    public PasswordMap() {
        pwordMap = new HashMap<String, Password>();
    }
/*Should I return booleans to let the user know
if these methods are successful?*/
    public void addPassword(String website, String password) throws Exception {
        Password newPword = new Password(password);
        pwordMap.put(website, newPword);
    }

    public void removePassword(String website){
        if(pwordMap.containsKey(website)){
            pwordMap.remove(website);
        }
    }

    public void changePassword(String website, String password) throws Exception {
        if(pwordMap.containsKey(website)){
            pwordMap.remove(website);
            this.addPassword(website, password);
        }
    }

    public void printPasswords() throws Exception {
        for(String p : pwordMap.keySet()){
            System.out.println(p + ": " + pwordMap.get(p).decrypt());
        }
    }
}