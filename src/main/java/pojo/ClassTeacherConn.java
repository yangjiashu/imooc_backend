package pojo;

public class ClassTeacherConn {
    private int id;
    private int teacherId;
    private int classId;

    @Override
    public String toString() {
        return "ClassTeacherConn{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", classId=" + classId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
