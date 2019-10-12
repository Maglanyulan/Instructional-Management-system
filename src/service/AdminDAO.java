package service;

import java.util.List;

import entity.MajorInfo;
import entity.RecruitmentInfo;
import entity.StuInfo;
import entity.TeacherInfo;
import entity.TeachingAnno;
import entity.TrainPlan;
import entity.UserInfo;

public interface AdminDAO {
	//查询所有学生资料 
	public List<StuInfo>queryAllStudent();
	
	//根据学生编号查询学生资料
	public StuInfo queryStudentsByid(String sid);
	//添加学生资料
	public boolean addStudent(StuInfo s);
	//修改
	public boolean updateStudent(StuInfo s);
	//删除
	public boolean deleteStudent(String sid);
		
	
	public boolean addUser(UserInfo u);
	public boolean deleteUser(String uid);
	
	
	public List<TeacherInfo>queryAllTeacher();
	//根据教师编号查询教师资料
	public TeacherInfo queryTeacherByid(String tid);
	//添加教师资料
	public void addTeacher(TeacherInfo t);
	//修改
	public boolean updateTeacher(TeacherInfo t);
	//删除
	public boolean deleteTeacher(String tid);
	
//培养计划
	//查询学院信息
	public List<MajorInfo> queryAllCollege();
	//根据学院查询专业
	public List<MajorInfo> queryMajorByCollege(String collegeid);
	//根据专业id查询专业
	public List<MajorInfo> queryEntityById(String collegeid);
	//根据专业id获取专业实体
	public MajorInfo queryEntityById2(String majorId);
	//添加培养计划
	public boolean addTrainPlan(TrainPlan t);

	
	//查询所有学院专业
	public List<MajorInfo>queryAllMajor();
	//添加学院专业
	public boolean addMajor(MajorInfo m);
	//修改
	public boolean updateMajor(MajorInfo m);
	//删除
	public boolean deleteMajor(String mid);
	//根据专业编号查询专业信息
	public MajorInfo queryMajorByid(String mid);
	
	//查询所有教学公告
	public List<TeachingAnno> queryAllAnno();
	//添加公告
	public boolean addAnno(TeachingAnno a);
	//删除
	public boolean deleteAnno(Integer aid);
	//根据公告编号查询公告信息
	public TeachingAnno queryAnnoByid(Integer aid);
	
	//招聘信息
	public List<RecruitmentInfo> queryAllRecruitment();
	public boolean addRecru(RecruitmentInfo r);
	public boolean deleteRecru(Integer rid);
	public RecruitmentInfo queryRecruByid(Integer rid);
	//查询培养计划列表
	public List<TrainPlan> queryAllPYList();
	
	}
