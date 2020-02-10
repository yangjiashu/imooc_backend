package service.impl;

import dao.ClassExamConnMapper;
import dao.ClassMapper;
import dao.ClassTeacherConnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;
import service.IClassService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    ClassMapper dao;
    @Autowired
    ClassTeacherConnMapper conn;
    @Autowired
    ClassExamConnMapper connExam;

    @Override
    public Classes findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Classes> findByTeacherId(int id) {
        List<ClassTeacherConn> classTeacherConn = conn.findClassesByTeacher(id);
        List<Classes> classes = new ArrayList<>();

        for (ClassTeacherConn connItem : classTeacherConn) {
            classes.add(findById(connItem.getClassId()));
        }

        return classes;
    }

    @Override
    public Classes findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Classes> findByExamId(int id) {
        List<ClassExamConn> classExamConns = connExam.findClassesByExam(id);
        List<Classes> classes = new ArrayList<>();
        for (ClassExamConn connItem : classExamConns) {
            classes.add(findById(connItem.getClassId()));
        }
        return classes;
    }
}
