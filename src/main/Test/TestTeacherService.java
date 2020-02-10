import dao.ClassMapper;
import dao.ClassTeacherConnMapper;
import dao.QuestionMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.ClassTeacherConn;
import pojo.Classes;
import pojo.Question;
import pojo.Teacher;
import service.IClassService;
import service.ITeacherService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TestTeacherService {
    ApplicationContext ioc;
    @Before
    public void before() {
        this.ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    // 测试通过
    @Test
    public void run1() {
        ITeacherService teacherService = (ITeacherService) ioc.getBean("teacherServiceImpl");
        Teacher teacher = teacherService.findByUsername("T201612345");
        System.out.println(teacher);
    }

    @Test
    public void run2() {
        System.out.println(ioc.containsBean("loginController"));
    }
    @Test
    public void run3() {
        ClassTeacherConnMapper dao = (ClassTeacherConnMapper) ioc.getBean("classTeacherConnMapper");
        List<ClassTeacherConn> teachers = dao.findTeachersByClass(2);
        System.out.println(teachers);
        List<ClassTeacherConn> classes = dao.findClassesByTeacher(1);
        System.out.println(classes);
    }

    @Test
    public void run4() {
        ClassMapper dao = (ClassMapper) ioc.getBean("classMapper");
        Classes classes = dao.findById(1);
        System.out.println(classes);
    }

    @Test
    public void run5() {
        ITeacherService teacherService = (ITeacherService) ioc.getBean("teacherServiceImpl");
        IClassService classService = (IClassService) ioc.getBean("classServiceImpl");
        List<Teacher> teachers = teacherService.findByClassId(1);
        System.out.println(teachers);
        List<Classes> classes =classService.findByTeacherId(1);
        System.out.println(classes);
    }

    @Test
    public void run6() {
        ITeacherService teacherService = (ITeacherService) ioc.getBean("teacherServiceImpl");
        Teacher teacher = new Teacher();
        teacher.setUsername("U201655555");
        teacher.setName("张惕远");
        teacher.setPassword("123456");
        teacherService.create(teacher);
        System.out.println(teacher.getId());
    }

}
