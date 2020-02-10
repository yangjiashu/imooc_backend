package dao;

import pojo.Student;

public interface StudentMapper {
    Student findById(int id);
    Student findByName(String name);
    Student findByUsername(String name);
    void create(Student student);
}
