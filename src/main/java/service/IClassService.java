package service;

import pojo.Classes;

import java.util.List;

public interface IClassService {
    Classes findById(int id);
    List<Classes> findByTeacherId(int id);
    List<Classes> findByExamId(int id);
    Classes findByName(String name);
}
