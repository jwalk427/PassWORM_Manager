package model;

public class User {
    private String userName;
    private String email;
    private Password pword;
    private PasswordMap pwordMap;
    

    public User(String Username, String Email, String password) throws Exception {
        userName = Username;
        email = Email;
        pword = new Password(password);
        pwordMap = new PasswordMap();
    }

    public User() throws Exception {
        userName = "default";
        email = "default@email.com";
        pword = new Password("default");
        pwordMap = new PasswordMap();
    }

    public String getUserName(){
        return userName;
    }

    public String getEmail(){
        return email;
    }

    public void addPword(String website, String password) throws Exception {
        pwordMap.addPassword(website, password);
    }

    public void removePword(String website){
        pwordMap.removePassword(website);
    }

    public void changePword(String website, String password) throws Exception {
        pwordMap.changePassword(website, password);
    }

    public void printPasswords() throws Exception {
        pwordMap.printPasswords();
    }

    /*Main class for testing/Debugging*/
    // public static void main(String[] args) throws Exception 
    // {
    //     User user = new User("jwalk427", "jwalk427@gmail.com", "password");
    //     user.addPword("www.test1.com", "password#1");
    //     user.addPword("www.test2.com", "password#2");
    //     user.addPword("www.test3.com", "password#3");
    //     System.out.println(user.getUserName()+"\n"+user.getEmail());
    //     user.printPasswords();
    //     user.removePword("www.test2.com");
    //     user.changePword("www.test3.com", "password#4");
    //     System.out.println("_________________________");
    //     user.printPasswords();
    // } 
}