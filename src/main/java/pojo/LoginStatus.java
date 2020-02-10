package pojo;

public class LoginStatus {
    private boolean success;
    private String verify;
    private int id;
    private String info;

    @Override
    public String toString() {
        return "LoginStatus{" +
                "success=" + success +
                ", verify='" + verify + '\'' +
                ", id=" + id +
                ", info='" + info + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
