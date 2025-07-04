package Model;

public class User {
    private String SSN;
    private String userName;
    private String userSurname;
    private String userPassword;
    private String userEmail;

    private String status;

    public User(String SSN, String userName, String userSurname, String userPassword, String userEmail, String status) {
        this.SSN = SSN;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters & setters

    public String getSSN() {
        return SSN;
    }

    public String getUserName() { return userName; }
    public String getUserSurname() { return userSurname; }
    public String getUserPassword() { return userPassword; }
    public String getUserEmail() { return userEmail; }

    public void setUserPassword(String newPassword) {
        this.userPassword = newPassword;
    }
}
