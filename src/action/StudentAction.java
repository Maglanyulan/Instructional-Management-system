/*学生登陆后可查询个人信息，查询课表，进行选课，查询个人成绩等功能
query查询所有学生
querycourse查询个人课表
makecourse生成课程表
queryScore查询成绩
Selectcourse选课
saveCourse保存选课信息*/
package action;

import java.util.ArrayList;
import java.util.List;

import entity.CourseInfo;
import entity.ScoreInfo;
import entity.ScoreInfoId;
import entity.StuInfo;
import entity.UserInfo;

import service.StudentDAO;
import service.TeacherDAO;
import service.UserDAO;
import service.impl.StudentDAOimpl;

public class StudentAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	
	private StudentDAO sdao;
	public void setstudentDAO(StudentDAO studentDAO){

		this.sdao=studentDAO;
	}
	private TeacherDAO tdao;
	public void setteacherDAO(TeacherDAO teacherDAO){
		this.tdao=teacherDAO;
	}
	
	public String query(){
		System.out.println("query调用");
		String sid=request.getParameter("sid");
		StuInfo s=sdao.queryStudentsByid(sid);
		session.setAttribute("my_student", s);
		return "query_stuinfo";

	}
	
	public String querycourse(){
		System.out.println("querycource调用");
		String sid=request.getParameter("sid");
		System.out.println(sid);
		StuInfo s=sdao.queryStudentsByid(sid);
		List<CourseInfo> listc=new ArrayList<CourseInfo>();
		List<ScoreInfo> list=sdao.queryScoreByid(s);
		List<String> lista=new ArrayList<String>();
		for(int i = 0 ; i < list.size() ; i++) {
			ScoreInfo attribute= list.get(i);
			String cid = attribute.getCourseInfo().getCourseId();
			CourseInfo c=sdao.queryCourseByid(cid);
			String id =c.getTeacherInfo().getTeacherId();
			String name=sdao.queryTeacherByid(id).getTName();
			lista.add(name);
			listc.add(c);	
		}
		session.setAttribute("userNames", lista);
		System.out.println(lista.get(0));
		session.setAttribute("my_course", listc);
		return "query_course";
	}

	
	public String makecourse(){
		System.out.println("makecourse调用-------------");
		String sid=request.getParameter("sid");
		System.out.println(sid);
		StuInfo s=sdao.queryStudentsByid(sid);
		List<ScoreInfo> list=sdao.queryScoreByid(s);
		
		for(int i = 0 ; i < list.size() ; i++) {
			ScoreInfo attribute= list.get(i);
			String cid = attribute.getCourseInfo().getCourseId();
			CourseInfo c=sdao.queryCourseByid(cid);
			String addr=c.getCourseTimeAddr();
			if(addr.length()==43){// 判断是否长度大于等于43
				String strsub=addr.substring(6,9);//一个参数表示截取传递的序号之后的部分
				String strsub1=addr.substring(10,13);//截取两个数字之间的部分
				String strsub2=addr.substring(28,31);
				String strsub3=addr.substring(32,35);
				System.out.println(strsub2);
				System.out.println(strsub3);
				if(strsub.equals("星期1")){
					if(strsub1.equals("1-2")){session.setAttribute("table11",c.getCourseName());}
					else if(strsub1.equals("3-4")){session.setAttribute("table12",c.getCourseName());}
					else if(strsub1.equals("5-6")){session.setAttribute("table13",c.getCourseName());}
					else if(strsub1.equals("7-8")){session.setAttribute("table14",c.getCourseName());}
				}
				else if(strsub.equals("星期2")){
					if(strsub1.equals("1-2")){session.setAttribute("table21",c.getCourseName());}
					else if(strsub1.equals("3-4")){session.setAttribute("table22",c.getCourseName());}
					else if(strsub1.equals("5-6")){session.setAttribute("table23",c.getCourseName());}
					else if(strsub1.equals("7-8")){session.setAttribute("table24",c.getCourseName());}
				}
				else if(strsub.equals("星期3")){
					if(strsub1.equals("1-2")){session.setAttribute("table31",c.getCourseName());}
					else if(strsub1.equals("3-4")){session.setAttribute("table32",c.getCourseName());}
					else if(strsub1.equals("5-6")){session.setAttribute("table33",c.getCourseName());}
					else if(strsub1.equals("7-8")){session.setAttribute("table34",c.getCourseName());}
				}
				else if(strsub.equals("星期4")){
					if(strsub1.equals("1-2")){session.setAttribute("table41",c.getCourseName());}
					else if(strsub1.equals("3-4")){session.setAttribute("table42",c.getCourseName());}
					else if(strsub1.equals("5-6")){session.setAttribute("table43",c.getCourseName());}
					else if(strsub1.equals("7-8")){session.setAttribute("table44",c.getCourseName());}
				}
				else if(strsub.equals("星期5")){
					if(strsub1.equals("1-2")){session.setAttribute("table51",c.getCourseName());}
					else if(strsub1.equals("3-4")){session.setAttribute("table52",c.getCourseName());}
					else if(strsub1.equals("5-6")){session.setAttribute("table53",c.getCourseName());}
					else if(strsub1.equals("7-8")){session.setAttribute("table54",c.getCourseName());}
				}
						
		
				if(strsub2.equals("星期1")){
					if(strsub3.equals("1-2")){session.setAttribute("table11",c.getCourseName());}
					else if(strsub3.equals("3-4")){session.setAttribute("table12",c.getCourseName());}
					else if(strsub3.equals("5-6")){session.setAttribute("table13",c.getCourseName());}
					else if(strsub3.equals("7-8")){session.setAttribute("table14",c.getCourseName());}
				}
						
				else if(strsub2.equals("星期2")){
					if(strsub3.equals("1-2")){session.setAttribute("table21",c.getCourseName());}
					else if(strsub3.equals("3-4")){session.setAttribute("table22",c.getCourseName());}
					else if(strsub3.equals("5-6")){session.setAttribute("table23",c.getCourseName());}
					else if(strsub3.equals("7-8")){session.setAttribute("table24",c.getCourseName());}
				}
						
				else if(strsub2.equals("星期3")){
					if(strsub3.equals("1-2")){session.setAttribute("table31",c.getCourseName());}
					else if(strsub3.equals("3-4")){session.setAttribute("table32",c.getCourseName());}
					else if(strsub3.equals("5-6")){session.setAttribute("table33",c.getCourseName());}
					else if(strsub3.equals("7-8")){session.setAttribute("table34",c.getCourseName());}
				}
				else if(strsub2.equals("星期4")){
					if(strsub3.equals("1-2")){session.setAttribute("table41",c.getCourseName());}
					else if(strsub3.equals("3-4")){session.setAttribute("table42",c.getCourseName());}
					else if(strsub3.equals("5-6")){session.setAttribute("table43",c.getCourseName());}
					else if(strsub3.equals("7-8")){session.setAttribute("table44",c.getCourseName());}
				}
				else if(strsub2.equals("星期5")){
					if(strsub3.equals("1-2")){session.setAttribute("table51",c.getCourseName());}
					else if(strsub3.equals("3-4")){session.setAttribute("table52",c.getCourseName());}
					else if(strsub3.equals("5-6")){session.setAttribute("table53",c.getCourseName());}
					else if(strsub3.equals("7-8")){session.setAttribute("table54",c.getCourseName());}
				}	
			}
		}
		return "make_course";
	}
	public String queryScore(){
		System.out.println("querycource调用");
		String sid=request.getParameter("sid");
		System.out.println(sid);
		StuInfo s=sdao.queryStudentsByid(sid);
		List<CourseInfo> listc=new ArrayList<CourseInfo>();
		List<ScoreInfo> list=sdao.queryScoreByid(s);
		List<String> lista=new ArrayList<String>();
		for(int i = 0 ; i < list.size() ; i++) {
			ScoreInfo attribute= list.get(i);
			String cid = attribute.getCourseInfo().getCourseId();
			CourseInfo c=sdao.queryCourseByid(cid);
			String id =c.getTeacherInfo().getTeacherId();
			String name=sdao.queryTeacherByid(id).getTName();
			lista.add(name);
			listc.add(c);	
		}
		session.setAttribute("my_score",list);
		session.setAttribute("userNames", lista);
		session.setAttribute("my_course", listc);
		return "query_score";
	}
	
	public String selectcourse(){
		System.out.println("selectcourse调用------------");
		String sid=request.getParameter("sid");
		System.out.println(sid);
		StuInfo s=sdao.queryStudentsByid(sid);
		List<CourseInfo> listc=new ArrayList<CourseInfo>();
		List<CourseInfo> listcou=new ArrayList<CourseInfo>();
		List<ScoreInfo> list=sdao.queryScoreByid(s);
		for(int i = 0 ; i < list.size() ; i++) {
			ScoreInfo attribute= list.get(i);
			String cid = attribute.getCourseInfo().getCourseId();
			CourseInfo c=sdao.queryCourseByid(cid);
			listc.add(c);
			if(attribute.getScore()!=null){
				listcou.add(c);
			}
		}
		session.setAttribute("my_course", listc);
		session.setAttribute("mysco_course", listcou);
		
		List<CourseInfo> listcall=tdao.queryAllCourse();
		List<String> lista=new ArrayList<String>();
		for(int i = 0 ; i < listcall.size() ; i++) {
			CourseInfo attribute= listcall.get(i);
			String id =attribute.getTeacherInfo().getTeacherId();
			String name=sdao.queryTeacherByid(id).getTName();
			lista.add(name);
		}
		session.setAttribute("userNames", lista);
		session.setAttribute("all_course", listcall);
		return "select_course";
	}
	
	
	public String saveCourse(){
		System.out.println("saveCoursee调用------------");
		String sid=request.getParameter("sid");
		StuInfo s=sdao.queryStudentsByid(sid);
		List<ScoreInfo> lists=sdao.queryScoreByid(s);
		String cou="0";
		System.out.println(sid);
		ScoreInfoId scoreid =new ScoreInfoId();
		ScoreInfo sco= new ScoreInfo();
		scoreid.setSId(sid);
		sco.setStuInfo(s);
		
		for(int j = 0 ; j < lists.size() ; j++) {
			ScoreInfo attribute= lists.get(j);
			String id = attribute.getCourseInfo().getCourseId();
			String S=attribute.getScore();
			CourseInfo c=sdao.queryCourseByid(id);
			
			scoreid.setCourId(id);
			
			sco.setId(scoreid);
			sco.setCourseInfo(c);
			//sco.setScore(S);
			if(S==null||"".equals(S)){
				sdao.deletScore(sco);
			}
		}
		int size=Integer.parseInt(request.getParameter("size"))+1;
		System.out.println(size);
		for(int i = 1 ; i<size; i++) {
			System.out.println(cou);
			System.out.println(request.getParameter(cou));
			if(request.getParameter(cou)!=null){
				String cid=request.getParameter(cou);
				CourseInfo c=sdao.queryCourseByid(cid);
				scoreid.setCourId(cid);
				
				//sco.setScore("null");
				sco.setCourseInfo(c);
				sco.setId(scoreid);
				sdao.addScore(sco);
			}
			cou=i+"";
		}
		
		request.setAttribute("sid",sid);
		return"save_course";
	}
}
