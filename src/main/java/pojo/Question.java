package pojo;


public class Question {
    private int id;
    private String desc;
    private String type;
    private String instruction;
    private int answerNum;
    private String answerContent;
    private int examId;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                ", instruction='" + instruction + '\'' +
                ", answerNum=" + answerNum +
                ", answerContent='" + answerContent + '\'' +
                ", examId=" + examId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}