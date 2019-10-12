package service;

import java.util.List;

import entity.CourseInfo;
import entity.ScoreInfo;
import entity.StuInfo;
import entity.TeacherInfo;
	 //ѧ����ҵ���߼��ӿ�
public interface StudentDAO {
		//����ѧ����Ų�ѯѧ������
		public StuInfo queryStudentsByid(String sid);
		
		//���ݿγ̱�Ų�ѯ�γ�
		public  CourseInfo queryCourseByid(String cid);
		
		//����ѧ����ѯ�ɼ���Ϣ
		public List<ScoreInfo> queryScoreByid(StuInfo s);
		
		//���ݽ�ʦ��Ų�ѯ��ʦ����
		public TeacherInfo queryTeacherByid(String tid);
		
		//��ӳɼ���Ϣ
		public boolean addScore(ScoreInfo s);
		
		//ɾ��ѧ��
		public boolean deletScore(ScoreInfo s);
		
	}
