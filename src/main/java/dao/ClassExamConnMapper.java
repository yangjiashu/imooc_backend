package dao;

import pojo.ClassExamConn;

import java.util.List;

public interface ClassExamConnMapper {
    List<ClassExamConn> findExamsByClass(int id);
    List<ClassExamConn> findClassesByExam(int id);
    void create(ClassExamConn classExamConn);
}
