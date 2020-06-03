package DOA.entity;

public class UserEntity {
    private String userName;
    private String password;
    private double balance;
    private String email;

    public UserEntity(){

    }

    public UserEntity(String userName, String password, double balance, String email) {
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
