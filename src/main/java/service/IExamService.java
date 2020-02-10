package service;

import pojo.Exam;

import java.util.List;

public interface IExamService {
    void create(Exam exam, List<String> classes);
    List<Exam> findByTeacherId(int id);
    void update(Exam exam);
}
