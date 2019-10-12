package service;

import java.util.List;

import entity.CourseInfo;
import entity.ScoreInfo;
import entity.StuInfo;
import entity.TeacherInfo;
	 //学生的业务逻辑接口
public interface StudentDAO {
		//根据学生编号查询学生资料
		public StuInfo queryStudentsByid(String sid);
		
		//根据课程编号查询课程
		public  CourseInfo queryCourseByid(String cid);
		
		//根据学生查询成绩信息
		public List<ScoreInfo> queryScoreByid(StuInfo s);
		
		//根据教师编号查询教师资料
		public TeacherInfo queryTeacherByid(String tid);
		
		//添加成绩信息
		public boolean addScore(ScoreInfo s);
		
		//删除学生
		public boolean deletScore(ScoreInfo s);
		
	}
