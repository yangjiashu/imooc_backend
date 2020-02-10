package service.impl;

import dao.ClassMapper;
import dao.ClassTeacherConnMapper;
import dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.ClassTeacherConn;
import pojo.Classes;
import pojo.Teacher;
import service.ITeacherService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    TeacherMapper dao;
    @Autowired
    ClassTeacherConnMapper conn;
    @Autowired
    ClassMapper classDao;

    @Override
    public Teacher findByUsername(String username) {
        return dao.findByUsername(username);
    }
    @Override
    public void create(Teacher teacher) {
        dao.create(teacher);
    }

    @Override
    public Teacher findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Teacher> findByClassId(int id) {
        List<ClassTeacherConn> classTeacherConn = conn.findTeachersByClass(id);
        List<Teacher> teachers = new ArrayList<>();

        for (ClassTeacherConn connItem : classTeacherConn) {
            teachers.add(findById(connItem.getTeacherId()));
        }

        return teachers;
    }

    @Override
    public Classes addClassByName(int teacherId, String className) {
        Classes classes = classDao.findByName(className);
        if (classes != null) {
            ClassTeacherConn classTeacherConn = new ClassTeacherConn();
            classTeacherConn.setClassId(classes.getId());
            classTeacherConn.setTeacherId(teacherId);
            this.conn.create(classTeacherConn);
        } else {
            classes = new Classes();
        }
        return classes;
    }

    @Override
    public void deleteClass(int teacherId, int classId) {
        ClassTeacherConn classTeacherConn = new ClassTeacherConn();
        classTeacherConn.setTeacherId(teacherId);
        classTeacherConn.setClassId(classId);
        conn.deleteClass(classTeacherConn);
    }
}
