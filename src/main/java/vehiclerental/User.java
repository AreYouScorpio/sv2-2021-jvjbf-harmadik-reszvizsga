package vehiclerental;

public class User {
    String username;
    String email;
    int balance;

    public void minusBalance(int sum){
        balance-=sum;
    }

    public User(String username, String email, int balance) {
        this.username = username;
        this.email = email;
        this.balance = balance;
    }

    public String getUserName() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
