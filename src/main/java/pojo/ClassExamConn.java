package pojo;

public class ClassExamConn {
    private int id;
    private int classId;
    private int examId;

    @Override
    public String toString() {
        return "ClassQuestionConn{" +
                "id=" + id +
                ", classId=" + classId +
                ", questionId=" + examId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
