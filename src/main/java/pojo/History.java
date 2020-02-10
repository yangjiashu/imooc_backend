package pojo;

public class History {
    private int id;
    private int questionId;
    private int teacherId;
    private int studentId;
    private boolean check;
    private String trueAns;
    private String studentAns;

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", teacherId=" + teacherId +
                ", studentId=" + studentId +
                ", check=" + check +
                ", trueAns='" + trueAns + '\'' +
                ", studentAns='" + studentAns + '\'' +
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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getTrueAns() {
        return trueAns;
    }

    public void setTrueAns(String trueAns) {
        this.trueAns = trueAns;
    }

    public String getStudentAns() {
        return studentAns;
    }

    public void setStudentAns(String studentAns) {
        this.studentAns = studentAns;
    }
}
