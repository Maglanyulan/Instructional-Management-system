package service.impl;
import java.util.List;
import service.UserDAO;
import entity.UserInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDAOimpl implements UserDAO{
	
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public UserInfo UserLogin(UserInfo u)
	{ 
		System.out.println("UserLogin±»µ÷ÓÃ..................");	
		String hql=""; 
		try {
			Session session=sessionFactory.getCurrentSession();
			hql="from UserInfo where UId=:id and UPassword=:pwd"; 
			Query query=session.createQuery(hql);
			query.setParameter("id", u.getUId());
			query.setParameter("pwd", u.getUPassword()); 
			List<UserInfo> list=query.list(); 
			if(list.size()>0) {
				return list.get(0); 
				}
			else { 
				return null ;
				} 
		} 
		catch(Exception ex){ 
			ex.printStackTrace();
			return null; 
		}
		finally {
		} 
		
	}


}
