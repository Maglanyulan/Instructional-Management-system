//登录界面

package action;
import com.opensymphony.xwork2.ModelDriven;

import entity.UserInfo;
import service.UserDAO;


public class LoginAction extends SuperAction  implements ModelDriven<UserInfo>{
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	
	//接收提交表格信息
	private UserInfo user = new UserInfo();//必须实例化，不需要setter,getter 
	@Override
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return user;
	} 

	//注入业务层
	private UserDAO udao;
	public void setuserDAO(UserDAO userDAO){
		this.udao=userDAO;
	}
	
	public String login(){
		//调用业务层：
		UserInfo u= udao.UserLogin(user);
		if(u!=null){
			session.setAttribute("loginUserName", u.getUId());
			if(u.getUId().length()==9){
				return "stu_login_success";
	        }else if(u.getUId().length()==8){
	        	return "tea_login_success";
	        }else{
	        	return "admin_login_success";
	        }
		}else {
			return "login_fail";
		}
	}
	
	public String logout()throws Exception{
		System.out.println("logout被调用了.....................");
		if(session.getAttribute("loginUser")!=null){
			session.removeAttribute("loginUser");
		}
		return "logout_success";
	}
}
