package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.*;
import service.IClassService;
import service.IExamService;
import service.IQuestionService;
import service.ITeacherService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherHomeController {

    @Autowired
    IClassService classService;
    @Autowired
    IQuestionService questionService;
    @Autowired
    IExamService examService;
    @Autowired
    ITeacherService teacherService;

    @RequestMapping("/classList")
    @ResponseBody
    public List<Classes> classList(int id) {
        return classService.findByTeacherId(id);
    }

    @RequestMapping("/examAdd")
    @ResponseBody
    public LoginStatus examAdd(@RequestBody Map<String, Object> map) {
        LoginStatus loginStatus = new LoginStatus();
        try {
            Exam exam = new Exam();
            exam.setTitle((String) map.get("title"));
            exam.setTeacherId((int) map.get("teacherId"));
            exam.setActive((boolean) map.get("active"));
            exam.setPublishDate(new Timestamp(new Date().getTime()));

            List<String> classes = (List<String>) map.get("classes");

            examService.create(exam, classes);

            Question question = new Question();
            List<Map<String, Object>> qmaps = (List<Map<String, Object>>) map.get("questionList");

            for (Map<String, Object> qmap : qmaps) {
                question.setDesc((String) qmap.get("desc"));
                question.setInstruction((String) qmap.get("instruction"));
                question.setType((String) qmap.get("type"));
                question.setAnswerNum((int) qmap.get("answerNum"));
                question.setAnswerContent((String) qmap.get("answerContent"));
                question.setExamId(exam.getId());
                List<String> selectItems;
                if (qmap.containsKey("selectItems")) {
                    selectItems = (List<String>) qmap.get("selectItems");
                } else {
                    selectItems = new ArrayList<>();
                }
                questionService.create(question, exam.getId(), selectItems);
            }

            loginStatus.setSuccess(true);
            loginStatus.setInfo("发布成功");
        } catch (Exception e) {
            e.printStackTrace();
            loginStatus.setSuccess(false);
            loginStatus.setInfo("发布失败,请重试");
            return loginStatus;
        }
        return loginStatus;
    }

    @RequestMapping("/questionList")
    @ResponseBody
    public List<Question> questionList(int id) {
        return questionService.findByExamId(id);
    }

    @RequestMapping("/examList")
    @ResponseBody
    public List<Exam> examList(int id) {
        return examService.findByTeacherId(id);
    }

    @RequestMapping("/questionUpdate")
    @ResponseBody
    public LoginStatus questionUpdate(@RequestBody Question question) {
        LoginStatus loginStatus = new LoginStatus();
        try {
            questionService.update(question);
        } catch (Exception e) {
            e.printStackTrace();
            loginStatus.setSuccess(false);
            loginStatus.setInfo("更新题目信息失败");
            return loginStatus;
        }
        loginStatus.setSuccess(true);
        loginStatus.setInfo("更新题目信息成功");
        return loginStatus;
    }

    @RequestMapping("/examUpdate")
    @ResponseBody
    public LoginStatus examUpdate(@RequestBody Exam exam) {
        LoginStatus loginStatus = new LoginStatus();
        try {
            examService.update(exam);
        } catch (Exception e) {
            e.printStackTrace();
            loginStatus.setSuccess(false);
            loginStatus.setInfo("更新习题信息失败");
            return loginStatus;
        }
        loginStatus.setSuccess(true);
        loginStatus.setInfo("更新习题信息成功");
        return loginStatus;
    }

    @RequestMapping("/examClasses")
    @ResponseBody
    public List<Classes> examClasses(int id) {
        return classService.findByExamId(id);
    }

    @RequestMapping("/getSelectItem")
    @ResponseBody
    public List<SelectItem> getSelectItem(int id) {
        return questionService.findSelectItems(id);
    }

    @RequestMapping("/classAdd")
    @ResponseBody
    public Classes classAdd(@RequestBody Map<String,Object>map) {
        String className = (String) map.get("className");
        int teacherId = (int) map.get("teacherId");
        return teacherService.addClassByName(teacherId, className);
    }

    @RequestMapping("/classRemove")
    @ResponseBody
    public LoginStatus classRemove(@RequestBody Map<String,Object>map) {
        LoginStatus loginStatus = new LoginStatus();
        int teacherId = (int) map.get("teacherId");
        int classId = (int) map.get("classId");
        try {
            teacherService.deleteClass(teacherId, classId);
            loginStatus.setSuccess(true);
            loginStatus.setInfo("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            loginStatus.setSuccess(false);
            loginStatus.setInfo("删除失败");
        }
        return loginStatus;
    }
}
