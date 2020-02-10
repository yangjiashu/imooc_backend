package pojo;

public class SelectItem {
    private int id;
    private int questionId;
    private String flag;
    private String desc;

    @Override
    public String toString() {
        return "SelectItem{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", flag='" + flag + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
