package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import entity.CourseInfo;
import entity.ScoreInfo;
import entity.TeacherInfo;
import service.TeacherDAO;

@Transactional
public class TeacherDAOimpl implements TeacherDAO{
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	@Override
	public List<CourseInfo> queryAllCourse() {
		// TODO Auto-generated method stub
		System.out.println("queryAllCourse 被调用..................");
		List<CourseInfo> list =null;
		String hql="";
		try {
			hql="from CourseInfo"; 
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			list =query.list();
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
	public List<CourseInfo> queryCoursebytid(TeacherInfo t) {
		System.out.println("queryCoursebytid 被调用..................");
		List<CourseInfo> list =null;
		String hql="";
		hql="select cou from CourseInfo cou where teacherInfo=:t"; 
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		query.setParameter("t",t);
		list =query.list();
		System.out.println(list.size());
		return list;
	}
	
	
	@Override
	public boolean addCourse(CourseInfo c) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(c);
			return true;
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			return false; 
		}
		finally {
		}
	}
	
	@Override
	public TeacherInfo queryTeacherByid(String tid) {
		// TODO Auto-generated method stub
		System.out.println("queryTeacherByid 被调用..................");
		TeacherInfo tea =null;
		try {
			Session session=sessionFactory.getCurrentSession();
			tea =(TeacherInfo)session.get(TeacherInfo.class,tid);
			return tea;
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			return tea; 
		}
		finally {
		}
	}

	@Override
	public List<ScoreInfo> findStuByCid(String cid) {
		// TODO Auto-generated method stub
		System.out.println("findStuByCid 被调用..................");
		List<ScoreInfo> list =null;
		String hql="";
		try {
			hql="from ScoreInfo s where s.id.courId = ?"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, cid);
			list =query.list();
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
	public boolean addTeacher(TeacherInfo t) {
		// TODO Auto-generated method stub
		System.out.println("addTeacher 被调用..................");
		Session session=sessionFactory.getCurrentSession();
		session.save(t);
		return true;
	}

	@Override
	public List<TeacherInfo> queryAllTeacher() {
		// TODO Auto-generated method stub
		System.out.println("queryAllTeacher 被调用..................");
		List<TeacherInfo> list =null;
		try {
			String hql="from TeacherInfo"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			list =query.list();
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
	public boolean updateScore(ScoreInfo s) {
		// TODO Auto-generated method stub
		System.out.println("updateScore 被调用..................");
		Session session=sessionFactory.getCurrentSession();
		session.update(s);
		return true;
	}



	
}
