package service;

import java.util.List;

import entity.RecruitmentInfo;
import entity.TeachingAnno;
import entity.TrainPlan;



public interface MainPageDAO {
	//查询所有教学公告
	public List<TeachingAnno> queryAllJXList();
	//查询教学公告内容
	public List<TeachingAnno> findJXContentByCid(Integer id);
	//查询所有招聘信息
	public List<RecruitmentInfo> queryAllZPList();
	//查询招聘信息内容
	public List<RecruitmentInfo> findZPContentByCid(Integer id);
	//查询培养计划内容
	public List<TrainPlan> findPYContentByCid(String id);
	//根据关键字查询培养计划列表
	public List<TrainPlan> findPYTitleBySearch(String sEARCH);
	//查询所有培养计划
	public List<TrainPlan> queryAllPYList();
}
