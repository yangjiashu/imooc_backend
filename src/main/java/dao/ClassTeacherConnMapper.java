package dao;

import pojo.ClassTeacherConn;

import java.util.List;

public interface ClassTeacherConnMapper {
    List<ClassTeacherConn> findTeachersByClass(int id);
    List<ClassTeacherConn> findClassesByTeacher(int id);
    void create(ClassTeacherConn classTeacherConn);
    void deleteClass(ClassTeacherConn classTeacherConn);
}
