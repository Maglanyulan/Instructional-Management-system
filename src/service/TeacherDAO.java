package service;

import java.util.List;

import entity.CourseInfo;
import entity.ScoreInfo;
import entity.TeacherInfo;
import entity.UserInfo;

public interface TeacherDAO {
	

	//查询所有课程资料 
	public List<CourseInfo>queryAllCourse();
	//根据教师实体查询课程
	public List<CourseInfo>queryCoursebytid(TeacherInfo t);
	
	//根据课程号找寻已选课学生
	public List<ScoreInfo> findStuByCid(String cid);
	
	//添加课程资料
	public boolean addCourse(CourseInfo c);
	
	
	//根据教师编号查询教师资料
	public TeacherInfo queryTeacherByid(String tid);
	public boolean addTeacher(TeacherInfo t);
	public List<TeacherInfo> queryAllTeacher();
	
	public boolean updateScore(ScoreInfo s);


}
