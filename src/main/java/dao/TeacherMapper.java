package dao;


import pojo.Teacher;

public interface TeacherMapper {
    Teacher findById(int id);
    Teacher findByName(String name);
    Teacher findByUsername(String username);
    void create(Teacher teacher);
}
