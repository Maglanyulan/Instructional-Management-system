package service;

import java.util.List;

import entity.CourseInfo;
import entity.ScoreInfo;
import entity.TeacherInfo;
import entity.UserInfo;

public interface TeacherDAO {
	

	//��ѯ���пγ����� 
	public List<CourseInfo>queryAllCourse();
	//���ݽ�ʦʵ���ѯ�γ�
	public List<CourseInfo>queryCoursebytid(TeacherInfo t);
	
	//���ݿγ̺���Ѱ��ѡ��ѧ��
	public List<ScoreInfo> findStuByCid(String cid);
	
	//��ӿγ�����
	public boolean addCourse(CourseInfo c);
	
	
	//���ݽ�ʦ��Ų�ѯ��ʦ����
	public TeacherInfo queryTeacherByid(String tid);
	public boolean addTeacher(TeacherInfo t);
	public List<TeacherInfo> queryAllTeacher();
	
	public boolean updateScore(ScoreInfo s);


}
