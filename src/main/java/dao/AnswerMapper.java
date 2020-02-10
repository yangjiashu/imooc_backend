package dao;

import pojo.Answer;

public interface AnswerMapper {
    Answer findByQuestionId(int id);
}
