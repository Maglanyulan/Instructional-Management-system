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
	//��ѯ����ѧ������ 
	public List<StuInfo>queryAllStudent();
	
	//����ѧ����Ų�ѯѧ������
	public StuInfo queryStudentsByid(String sid);
	//���ѧ������
	public boolean addStudent(StuInfo s);
	//�޸�
	public boolean updateStudent(StuInfo s);
	//ɾ��
	public boolean deleteStudent(String sid);
		
	
	public boolean addUser(UserInfo u);
	public boolean deleteUser(String uid);
	
	
	public List<TeacherInfo>queryAllTeacher();
	//���ݽ�ʦ��Ų�ѯ��ʦ����
	public TeacherInfo queryTeacherByid(String tid);
	//��ӽ�ʦ����
	public void addTeacher(TeacherInfo t);
	//�޸�
	public boolean updateTeacher(TeacherInfo t);
	//ɾ��
	public boolean deleteTeacher(String tid);
	
//�����ƻ�
	//��ѯѧԺ��Ϣ
	public List<MajorInfo> queryAllCollege();
	//����ѧԺ��ѯרҵ
	public List<MajorInfo> queryMajorByCollege(String collegeid);
	//����רҵid��ѯרҵ
	public List<MajorInfo> queryEntityById(String collegeid);
	//����רҵid��ȡרҵʵ��
	public MajorInfo queryEntityById2(String majorId);
	//��������ƻ�
	public boolean addTrainPlan(TrainPlan t);

	
	//��ѯ����ѧԺרҵ
	public List<MajorInfo>queryAllMajor();
	//���ѧԺרҵ
	public boolean addMajor(MajorInfo m);
	//�޸�
	public boolean updateMajor(MajorInfo m);
	//ɾ��
	public boolean deleteMajor(String mid);
	//����רҵ��Ų�ѯרҵ��Ϣ
	public MajorInfo queryMajorByid(String mid);
	
	//��ѯ���н�ѧ����
	public List<TeachingAnno> queryAllAnno();
	//��ӹ���
	public boolean addAnno(TeachingAnno a);
	//ɾ��
	public boolean deleteAnno(Integer aid);
	//���ݹ����Ų�ѯ������Ϣ
	public TeachingAnno queryAnnoByid(Integer aid);
	
	//��Ƹ��Ϣ
	public List<RecruitmentInfo> queryAllRecruitment();
	public boolean addRecru(RecruitmentInfo r);
	public boolean deleteRecru(Integer rid);
	public RecruitmentInfo queryRecruByid(Integer rid);
	//��ѯ�����ƻ��б�
	public List<TrainPlan> queryAllPYList();
	
	}
