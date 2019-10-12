package db;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;  // �Ự��������
	// ���췽��˽�л�����֤����ģʽ
	private MyHibernateSessionFactory(){}
	// ���еľ�̬��������ûỰ��������
	public static SessionFactory getSessionFactory(){
	    if(sessionFactory==null){
	        Configuration config = new Configuration().configure("hibernate.cfg.xml");
	        sessionFactory = config.buildSessionFactory();
	        return sessionFactory;
	    } else{
	        return sessionFactory;
	    }
	}
}
