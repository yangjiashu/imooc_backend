package pojo;

public class LoginJson {
    public String username;
    public String password;
    public String verify;

    @Override
    public String toString() {
        return "LoginJson{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verify='" + verify + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
