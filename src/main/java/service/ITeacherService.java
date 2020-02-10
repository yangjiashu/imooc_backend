package service;

import org.springframework.stereotype.Service;
import pojo.Classes;
import pojo.Teacher;

import java.util.List;

public interface ITeacherService {
    Teacher findById(int id);
    Teacher findByUsername(String username);
    void create(Teacher teacher);
    List<Teacher> findByClassId(int id);
    Classes addClassByName(int teacherId, String className);
    void deleteClass(int teacherId, int classId);
}
