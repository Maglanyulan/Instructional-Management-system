package service;

import java.util.List;

import entity.RecruitmentInfo;
import entity.TeachingAnno;
import entity.TrainPlan;



public interface MainPageDAO {
	//��ѯ���н�ѧ����
	public List<TeachingAnno> queryAllJXList();
	//��ѯ��ѧ��������
	public List<TeachingAnno> findJXContentByCid(Integer id);
	//��ѯ������Ƹ��Ϣ
	public List<RecruitmentInfo> queryAllZPList();
	//��ѯ��Ƹ��Ϣ����
	public List<RecruitmentInfo> findZPContentByCid(Integer id);
	//��ѯ�����ƻ�����
	public List<TrainPlan> findPYContentByCid(String id);
	//���ݹؼ��ֲ�ѯ�����ƻ��б�
	public List<TrainPlan> findPYTitleBySearch(String sEARCH);
	//��ѯ���������ƻ�
	public List<TrainPlan> queryAllPYList();
}
