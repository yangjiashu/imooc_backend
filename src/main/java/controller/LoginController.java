package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.LoginJson;
import pojo.LoginStatus;
import pojo.Student;
import pojo.Teacher;
import service.IClassService;
import service.IStudentService;
import service.ITeacherService;

import java.util.Map;

@Controller

public class LoginController {
    @Autowired
    ITeacherService teacherService;
    @Autowired
    IStudentService studentService;
    @Autowired
    IClassService classService;

    @ResponseBody
    @RequestMapping("/login")
    public LoginStatus login(@RequestBody LoginJson loginJson) {
        String username = loginJson.getUsername();
        String password = loginJson.getPassword();
        String verify = loginJson.getVerify();
        LoginStatus loginStatus = new LoginStatus();
        if ("teacher".equals(verify)) {
            loginStatus.setVerify("teacher");
            Teacher teacher = teacherService.findByUsername(username);
            if (teacher != null) { // 账户存在，验证密码
                if (teacher.getPassword().equals(password)) {
                    loginStatus.setSuccess(true);
                    loginStatus.setInfo("登陆成功");
                    loginStatus.setId(teacher.getId());
                    System.out.println(teacher.getId());
                } else {
                    loginStatus.setSuccess(false);
                    loginStatus.setInfo("密码错误");
                }
            } else {// 账号不存在
                loginStatus.setSuccess(false);
                loginStatus.setInfo("该账号不存在");
            }
        }

        if ("student".equals(verify)) {
            loginStatus.setVerify("student");
            Student student = studentService.findByUsername(username);
            if (student != null) { // 账户存在，验证密码
                if (student.getPassword().equals(password)) {
                    loginStatus.setSuccess(true);
                    loginStatus.setInfo("登陆成功");
                    int id = student.getId();
                    loginStatus.setId(id);
                } else {
                    loginStatus.setSuccess(false);
                    loginStatus.setInfo("密码错误");
                }
            } else {// 账号不存在
                loginStatus.setSuccess(false);
                loginStatus.setInfo("该账号不存在");
            }
        }
        return loginStatus;
    }

    @ResponseBody
    @RequestMapping("/register")
    public LoginStatus register(@RequestBody Map<String, Object> map) {
        LoginStatus loginStatus = new LoginStatus();
        String verify = (String) map.get("verify");
        String name = (String) map.get("name");
        String password = (String) map.get("password");
        String username = (String) map.get("username");
        String className = (String) map.get("class");
        if ("teacher".equals(verify)) {
            if (teacherService.findByUsername(username) != null) {
                loginStatus.setSuccess(false);
                loginStatus.setInfo("用户名已存在，请重新设置用户名或直接登陆");
                loginStatus.setVerify("teacher");
            } else {
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setUsername(username);
                teacher.setPassword(password);
                teacherService.create(teacher);
                loginStatus.setSuccess(true);
                loginStatus.setInfo("注册成功");
                loginStatus.setVerify("teacher");
                loginStatus.setId(teacher.getId());
            }
        }
        if ("student".equals(verify)) {
            if (studentService.findByUsername(username) != null) {
                loginStatus.setSuccess(false);
                loginStatus.setInfo("用户名已存在，请重新设置用户名或直接登陆");
                loginStatus.setVerify("student");
            } else {
                Student student= new Student();
                student.setName(name);
                student.setUsername(username);
                student.setPassword(password);
                student.setClassId(classService.findByName(className).getId());
                studentService.create(student);
                loginStatus.setSuccess(true);
                loginStatus.setInfo("注册成功");
                loginStatus.setVerify("student");
                loginStatus.setId(student.getId());
            }
        }
        return loginStatus;
    }
}
