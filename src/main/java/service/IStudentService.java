package service;

import pojo.Student;

public interface IStudentService {
    Student findByUsername(String username);
    void create(Student student);
}
