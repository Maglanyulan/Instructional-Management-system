package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.transaction.annotation.Transactional;

import entity.CourseInfo;
import entity.ScoreInfo;
import entity.StuInfo;
import entity.TeacherInfo;
import service.StudentDAO;
@Transactional
public class StudentDAOimpl implements StudentDAO{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Override
	public StuInfo queryStudentsByid(String sid) {
		System.out.println("queryStudentsByid调用");
		Session session=sessionFactory.getCurrentSession();
		StuInfo s =(StuInfo)session.get(StuInfo.class,sid);
		return s;
	}

	@Override
	public List<ScoreInfo> queryScoreByid(StuInfo s) {
		System.out.println("queryScoreByid调用");
		Session session=sessionFactory.getCurrentSession();
		String hql="select sco from ScoreInfo sco where stuInfo=:s"; 
		Query query=session.createQuery(hql);
		query.setParameter("s",s);
		List<ScoreInfo> list =query.list();
		return list;
	}
	@Override
	public CourseInfo queryCourseByid(String cid) {
		System.out.println("queryCourseByid调用");
		Session session=sessionFactory.getCurrentSession();
		CourseInfo c =(CourseInfo)session.get(CourseInfo.class,cid);
		return c;
	}
	@Override
	public TeacherInfo queryTeacherByid(String tid) {
		Session session=sessionFactory.getCurrentSession();
		TeacherInfo t =(TeacherInfo)session.get(TeacherInfo.class,tid);
		return t;
	}
	@Override
	public boolean addScore(ScoreInfo s) {
		System.out.println("addScore 被调用..................");
		Session session=sessionFactory.getCurrentSession();
		session.save(s);
		return true;
	}
	@Override
	public boolean deletScore(ScoreInfo s) {
		System.out.println("deletScore 被调用..................");
		Session session=sessionFactory.getCurrentSession();
		session.delete(s);
		return true;
	}

	
	
	
}
