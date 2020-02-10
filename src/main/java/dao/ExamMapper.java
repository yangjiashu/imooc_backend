package dao;

import pojo.Exam;

import java.util.List;

public interface ExamMapper {
    void create(Exam exam);
    List<Exam> findByTeacherId(int id);
    void update(Exam exam);
}
