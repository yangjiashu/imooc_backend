package service;

import pojo.Question;
import pojo.SelectItem;

import java.util.List;

public interface IQuestionService {
    void create(Question question, int examId, List<String> selectItems);
    List<Question> findByExamId(int id);
    void update(Question question);
    List<SelectItem> findSelectItems(int id);
}
