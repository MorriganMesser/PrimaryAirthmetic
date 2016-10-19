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
import edu.tju.goliath.service.GradeServiceI;
import edu.tju.goliath.service.ParentServiceI;
import edu.tju.goliath.service.StudentServiceI;
import edu.tju.goliath.service.TeacherServiceI;
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

	private TeacherServiceI teacherservice;
	
	
	public TeacherServiceI getTeacherservice() {
		return teacherservice;
	}

	@Autowired
	public void setTeacherservice(TeacherServiceI teacherservice) {
		this.teacherservice = teacherservice;
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
	
//	@Test
//	public void test3() {
//		Student stu= stuService.getStuByName("tianhongce2888");
////		List<Grade> gradelist = gradeService.getGradesByStuid(1);
//		
//		logger.info(JSON.toJSONStringWithDateFormat(stu, "yyyy-MM-dd HH:mm:ss"));
//	}

	//		stu.setStupwd(stupwd);
	//		stuservice.updateStuByIdSelective(stu);
	
//	@Test
//	public void test4() {
//		Student stu= stuService.getStuByName("qq9999999");
////		stu.setStupwd("qq");
////		stuService.updateStuByIdSelective(stu);
//		System.out.println(null==stu);
//		logger.info(JSON.toJSONStringWithDateFormat(stu, "yyyy-MM-dd HH:mm:ss"));
//	}


	//	@Test
//	public void test5() {
//		List<Parent> parentlist = parentService.getAllParent();
////		System.out.println(null==stu);
//		logger.info(JSON.toJSONStringWithDateFormat(parentlist, "yyyy-MM-dd HH:mm:ss"));
//	}
//	@Test
//	public void test6() {
//		List<Teacher> teacherlist = teacherservice.getAllTeacher();
//		logger.info(JSON.toJSONStringWithDateFormat(teacherlist, "yyyy-MM-dd HH:mm:ss"));
//	}
//	@Test
//	public void test7() {
//		Grade grade = gradeService.getGradeByName("tataa");
//		logger.info(JSON.toJSONStringWithDateFormat(grade, "yyyy-MM-dd HH:mm:ss"));
//	}
	
	/*
	 * Map param = new HashMap();
		param.put("posname", posname);
		param.put("company", company);
		param.put("dept", dept);
		param.put("place", place);
	 */
	
//	@Test
//	public void test8() {
//		Timestamp starttime = new Timestamp(System.currentTimeMillis());  
//		Timestamp endtime = new Timestamp(System.currentTimeMillis());  
//        String tsStr = "2011-05-09 12:25:00";   
//        String tsStr2 = "2016-10-19 12:00:00"; 
//        try {   
//        	starttime = Timestamp.valueOf(tsStr);
//        	endtime = Timestamp.valueOf(tsStr2);
//            System.out.println("时间"+starttime+"-------"+endtime);   
//        } catch (Exception e) {   
//            e.printStackTrace();   
//        }  
//		
//		Map param = new HashMap();
//		//param.put("gradestuid", 1);
//		param.put("graderank", "一级-青铜");
//		param.put("grademodel", "考试");
//		param.put("starttime", starttime);
//		param.put("endtime", endtime);
//		List<Grade> gradelist = gradeService.getGradesByStuidAndRankAndModel(param);
//		logger.info(JSON.toJSONStringWithDateFormat(gradelist, "yyyy-MM-dd HH:mm:ss"));
//	}
//	
	@Test
	public void test9() {
		
		Integer a =3;
		Integer b = 4;
		System.out.println(a+b);
		List<Grade> gradelist = gradeService.getAllGrades();
		logger.info(JSON.toJSONStringWithDateFormat(gradelist, "yyyy-MM-dd HH:mm:ss"));
	}
}


