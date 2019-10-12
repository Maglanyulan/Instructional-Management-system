package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import entity.MajorInfo;
import entity.RecruitmentInfo;
import entity.StuInfo;
import entity.TeacherInfo;
import entity.TeachingAnno;
import entity.TrainPlan;
import entity.UserInfo;
import service.AdminDAO;



@Transactional
public class AdminDAOimpl implements AdminDAO{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public List<StuInfo> queryAllStudent() {
		// TODO Auto-generated method stub
		List<StuInfo> list =null;
		String hql="";
		try {
			hql="from StuInfo"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			list =query.list();
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
	public StuInfo queryStudentsByid(String sid) {
		Session session=sessionFactory.getCurrentSession();
		StuInfo s =(StuInfo)session.get(StuInfo.class,sid);
		return s;

	}
	@Override
	public boolean updateStudent(StuInfo s) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(s);
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
	public boolean addStudent(StuInfo s) {
		// TODO Auto-generated method stub
		//s.setStuId(stuId);
		System.out.println("addStudent 被调用..................");
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(s);
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
	public boolean deleteStudent(String sid) {
		try{
			Session session=sessionFactory.getCurrentSession();
			StuInfo s =(StuInfo)session.get(StuInfo.class,sid);
			session.delete(s);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		finally{
		}
	}
	

	
	@Override
	public List<TeacherInfo> queryAllTeacher() {
		// TODO Auto-generated method stub
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
	public TeacherInfo queryTeacherByid(String tid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		TeacherInfo t =(TeacherInfo)session.get(TeacherInfo.class,tid);
		return t;
	}

	@Override
	public void addTeacher(TeacherInfo t) {
		System.out.println("addTeacher 被调用..................");
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public boolean updateTeacher(TeacherInfo t) {
		Session session=sessionFactory.getCurrentSession();
		session.update(t);
		return true;
	}

	@Override
	public boolean deleteTeacher(String tid) {
		Session session=sessionFactory.getCurrentSession();
		TeacherInfo t =(TeacherInfo)session.get(TeacherInfo.class,tid);
		session.delete(t);
		return true;
	}

	
	@Override
	public boolean addUser(UserInfo u) {
		// TODO Auto-generated method stub
		System.out.println("addUser 被调用..................");
		Session session=sessionFactory.getCurrentSession();
		session.save(u);
		return true;
	}

	@Override
	public boolean deleteUser(String uid) {
		Session session=sessionFactory.getCurrentSession();
		UserInfo u =(UserInfo)session.get(UserInfo.class,uid);
		session.delete(u);
		return true;
	}
	
	@Override
	public List<MajorInfo> queryAllCollege() {
		List<MajorInfo> list =null;
		String hql="";
		try {
			hql="from MajorInfo group by college"; 
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			list =query.list();
			System.out.println(list.size());
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
	public List<MajorInfo> queryMajorByCollege(String collegeid) {
		List<MajorInfo> list =null;
		String hql="";
		try {
			hql="from MajorInfo WHERE majorId like :name"; 
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			query.setParameter("name", collegeid+"__");
			list =query.list();
			System.out.println(list.size());
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
	public List<MajorInfo> queryEntityById(String collegeid) {
		List<MajorInfo> list =null;
		String hql="";
		try {
			hql="from MajorInfo WHERE majorId = ?"; 
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			query.setParameter(0, collegeid);
			list =query.list();
			System.out.println(list.size());
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
	public MajorInfo queryEntityById2(String majorId) {
		MajorInfo m =null;
		try {
			Session session=sessionFactory.getCurrentSession();
			m =(MajorInfo)session.get(MajorInfo.class,majorId);
			return m;
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			return null; 
		}
		finally {
		}
	}

	@Override
	public boolean addTrainPlan(TrainPlan t) {
		Session session=sessionFactory.getCurrentSession();
		session.save(t);
		return true;
	}
	
	
	//学院专业
	@Override
	public List<MajorInfo> queryAllMajor() {
		List<MajorInfo> list =null;
		String hql="";
		try {
			hql="from MajorInfo"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			list =query.list();
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
	public boolean addMajor(MajorInfo m) {
		System.out.println("addMajor 被调用..................");
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(m);
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
	public boolean updateMajor(MajorInfo m) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(m);
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
	public boolean deleteMajor(String mid) {
		try{
			Session session=sessionFactory.getCurrentSession();
			MajorInfo m =(MajorInfo)session.get(MajorInfo.class,mid);
			session.delete(m);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		finally{
		}
	}

	@Override
	public MajorInfo queryMajorByid(String mid) {
		Session session=sessionFactory.getCurrentSession();
		MajorInfo m =(MajorInfo)session.get(MajorInfo.class,mid);
		return m;
	}

	@Override
	public List<TeachingAnno> queryAllAnno() {
		List<TeachingAnno> list =null;
		String hql="";
		try {
			hql="from TeachingAnno"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			list =query.list();
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
	public boolean addAnno(TeachingAnno a) {
		System.out.println("addAnno 被调用..................");
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(a);
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
	public TeachingAnno queryAnnoByid(Integer aid) {
		Session session=sessionFactory.getCurrentSession();
		TeachingAnno a =(TeachingAnno)session.get(TeachingAnno.class,aid);
		return a;
	}
	
	@Override
	public boolean deleteAnno(Integer aid) {
		try{
			Session session=sessionFactory.getCurrentSession();
			TeachingAnno a =(TeachingAnno)session.get(TeachingAnno.class,aid);
			session.delete(a);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		finally{
		}
	}


	@Override
	public List<RecruitmentInfo> queryAllRecruitment() {
		List<RecruitmentInfo> list =null;
		String hql="";
		try {
			hql="from RecruitmentInfo"; 
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			list =query.list();
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
	public boolean addRecru(RecruitmentInfo r) {
		System.out.println("addRecru 被调用..................");
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(r);
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
	public boolean deleteRecru(Integer rid) {
		try{
			Session session=sessionFactory.getCurrentSession();
			RecruitmentInfo r =(RecruitmentInfo)session.get(RecruitmentInfo.class,rid);
			session.delete(r);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		finally{
		}
	}

	@Override
	public RecruitmentInfo queryRecruByid(Integer rid) {
		Session session=sessionFactory.getCurrentSession();
		RecruitmentInfo r =(RecruitmentInfo)session.get(RecruitmentInfo.class,rid);
		return r;
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