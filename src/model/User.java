package model;

public class User {
    private String userName;
    private String email;
    private Password pword;
    private AccountMap acctMap;
    

    public User(String Username, String Email, String password) throws Exception {
        userName = Username;
        email = Email;
        pword = new Password(password);
        acctMap = new AccountMap();
    }

    public User() throws Exception {
        userName = "default";
        email = "default@email.com";
        pword = new Password("default");
        acctMap = new AccountMap();
    }

    public String getUserName(){
        return userName;
    }

    public String getEmail(){
        return email;
    }

    public void addAccount(String title, String username, String url, String password, String notes) throws Exception {
        acctMap.addAccount(title, username, url, password, notes);
    }

    public void removeAccount(String website){
        acctMap.removeAccount(website);
    }

    public void changeAccount(String title, String username, String url, String password, String notes) throws Exception {
        acctMap.changeAccount(title, username, url, password, notes);
    }

    public void printAccounts() throws Exception {
        acctMap.printAccounts();
    }

    /*Main class for testing/Debugging*/
    // public static void main(String[] args) throws Exception 
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