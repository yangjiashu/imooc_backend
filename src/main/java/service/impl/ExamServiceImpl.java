package service.impl;

import dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;
import service.IExamService;

import java.util.List;

@Service
public class ExamServiceImpl implements IExamService {
    @Autowired
    ExamMapper examMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    ClassExamConnMapper connMapper;

    @Override
    public void create(Exam exam, List<String> classes) {
        examMapper.create(exam);
        int id = exam.getId();

        // 加入关联表
        ClassExamConn conn = new ClassExamConn();
        for (String className: classes) {
            // 将班级名称转换为班级id然后加入关联表中
            conn.setClassId(classMapper.findByName(className).getId());
            conn.setExamId(id);
            connMapper.create(conn);
        }

    }

    @Override
    public List<Exam> findByTeacherId(int id) {
        return examMapper.findByTeacherId(id);
    }

    @Override
    public void update(Exam exam) {
        examMapper.update(exam);
    }

}
