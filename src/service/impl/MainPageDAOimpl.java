package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import entity.RecruitmentInfo;
import entity.ScoreInfo;
import entity.StuInfo;
import entity.TeachingAnno;
import entity.TrainPlan;

import service.MainPageDAO;

@Transactional
public class MainPageDAOimpl implements MainPageDAO{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public List<TeachingAnno> queryAllJXList() {
//		return null;
		// TODO Auto-generated method stub
		List<TeachingAnno> list =null;
		String hql="";
		try {
			hql="from TeachingAnno order by publishTime desc"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			list =query.list();
			System.out.println("getJXList_DAO 被调用..................");
			return list;
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			return null; 
		}
		finally {
		}
	}

	public List<TeachingAnno> findJXContentByCid(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("findJXContentByCid 被调用..................");
		List<TeachingAnno> list =null;
		String hql="";
		try {
			hql="from TeachingAnno t where t.TAnnoId = ?"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, id);
			list =query.list();
			System.out.println("list 被调用..................");
			return list;
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			return list; 
		}
		finally {
		} 
	}

	@Override
	public List<RecruitmentInfo> queryAllZPList() {
		List<RecruitmentInfo> list =null;
		String hql="";
		try {
			hql="from RecruitmentInfo order by recruDate desc"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			list =query.list();
			System.out.println("list 被调用..................");
			return list;
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			return null; 
		}
		finally {
		}
	}

	@Override
	public List<RecruitmentInfo> findZPContentByCid(Integer id) {
		System.out.println("findJXContentByCid 被调用..................");
		List<RecruitmentInfo> list =null;
		String hql="";
		try {
			hql="from RecruitmentInfo r where r.recruId = ?"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, id);
			list =query.list();
			System.out.println("list 被调用..................");
			return list;
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			return list; 
		}
		finally {
		} 
	}

	@Override
	public List<TrainPlan> findPYContentByCid(String id) {
		System.out.println("findPYContentByCid 被调用..................");
		List<TrainPlan> list =null;		
		String hql="";
		try {
			hql="from TrainPlan t where t.planId = ?"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, id);
			list =query.list();
			System.out.println("pylist 被调用..................");
			return list;
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			System.out.println("err 被调用..................");
			return list; 
		}
		finally {
		} 
	}

	@Override
	public List<TrainPlan> findPYTitleBySearch(String sEARCH) {
		List<TrainPlan> list =null;
		String hql="";
		try {
			hql="from TrainPlan t where t.planId LIKE :name or t.college LIKE :name or t.grade LIKE :name or t.major LIKE :name or t.trainLevel LIKE :name or t.degree LIKE :name or t.trainProgram LIKE :name order by grade desc";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("name", "%"+sEARCH+"%");
			list =query.list();
			if(list.size() == 0){
				return null;
			}else{
				return list;
			}
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			System.out.println("err 被调用..................");
			return null; 
		}
		finally {
		} 
	}

	@Override
	public List<TrainPlan> queryAllPYList() {
		List<TrainPlan> list =null;
		String hql="";
		try {
			hql="from TrainPlan order by grade desc";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			list =query.list();
			System.out.println("dao_queryAllPYList 被调用..................");
			return list;
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			return null; 
		}
		finally {
		}
	}


	
	
	
	
	
	
}
