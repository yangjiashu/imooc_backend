package dao;

import pojo.Question;

import java.util.List;

public interface QuestionMapper {
    Question findById(int id);
    void create(Question question);
    List<Question> findByExamId(int id);
    void update(Question question);
}
