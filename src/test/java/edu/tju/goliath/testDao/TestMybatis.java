package edu.tju.goliath.testDao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import edu.tju.goliath.entity.Grade;
import edu.tju.goliath.entity.Parent;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.entity.User;
import edu.tju.goliath.service.GradeServiceI;
import edu.tju.goliath.service.ParentServiceI;
import edu.tju.goliath.service.StudentServiceI;
import edu.tju.goliath.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMybatis {

	private static final Logger logger = Logger.getLogger(TestMybatis.class);

	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	private StudentServiceI stuService;
	
	public StudentServiceI getStuService() {
		return stuService;
	}

	@Autowired
	public void setStuService(StudentServiceI stuService) {
		this.stuService = stuService;
	}
	
	private ParentServiceI parentService;
	
	public ParentServiceI getParentService() {
		return parentService;
	}

	@Autowired
	public void setParentService(ParentServiceI parentService) {
		this.parentService = parentService;
	}
	
	private GradeServiceI gradeService;

	public GradeServiceI getGradeService() {
		return gradeService;
	}

	@Autowired
	public void setGradeService(GradeServiceI gradeService) {
		this.gradeService = gradeService;
	}

//	@Test
//	public void test1() {
//		User u = userService.getUserById(1);
//		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
//	}


//	@Test
//	public void test2() {
////		Student stu=stuService.getStuById(8);
//		Student stu= stuService.getStuByName("tianhongce2");
////		Parent par= parentService.getParentByEmail("1196585084@qq.com");
//		
//		logger.info(JSON.toJSONStringWithDateFormat(stu, "yyyy-MM-dd HH:mm:ss"));
//	}
	
	@Test
	public void test3() {
		Student stu= stuService.getStuByName("tianhongce2");
		List<Grade> gradelist = gradeService.getGradesByStuid(1);
		
		logger.info(JSON.toJSONStringWithDateFormat(gradelist, "yyyy-MM-dd HH:mm:ss"));
	}

}


