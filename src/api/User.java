package api;

public class User {

    private String userId;
    private String userName;
    private String password;
    private String email;

    public User() {
        userName = null;
        password = null;
        email = null;
    }

    public User(String userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
