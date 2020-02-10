package service.impl;

import dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;
import service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    StudentMapper dao;

    @Override
    public Student findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public void create(Student student) {
        dao.create(student);
    }
}
