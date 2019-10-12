 /*
  * 教务管理员登陆后可对系统进行管理。
  * 发布公告，查询和修改所有学生/教师的信息；
  * 对学院、专业信息进行修改等功能；
  * 提供培养计划添加模块，可按学院、专业、年级的分类录入培养计划;
  */
package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ModelDriven;

import service.AdminDAO;
import service.MainPageDAO;
import entity.MajorInfo;
import entity.RecruitmentInfo;
import entity.StuInfo;
import entity.TeacherInfo;
import entity.TeachingAnno;
import entity.TrainPlan;
import entity.UserInfo;

public class AdminAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	
	private AdminDAO adao;
	public void setadminDAO(AdminDAO adminDAO){
		System.out.println("setadminDAO 被调用..................");
		this.adao=adminDAO;
	}
	
	
	//查询学生资料
	public String stuquery() {
		System.out.println("stuquery 被调用..................");
		List<StuInfo> list=adao.queryAllStudent();
		if(list!=null&&list.size()>0){
			session.setAttribute("studentlist",list);
		}
		return "stu_query";
	}
	
	//删除学生资料
	public String studelete() {
		String sid=request.getParameter("sid");
		System.out.println(sid);
		adao.deleteStudent(sid);
		adao.deleteUser(sid);
		return "stu_delete";
	}
	
	//添加学生资料
	public String stuadd() {
		System.out.println("stuadd 被调用..................");
		StuInfo s =new StuInfo();
		s.setStuAddr(request.getParameter("stuAddr"));
		s.setStuName(request.getParameter("stuName"));
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String aString=request.getParameter("stuBirth");
		Date date=null;
		try { 
			date = sdf.parse(aString); 
			s.setStuBirth(date);
		}catch (ParseException e) { 
			e.printStackTrace();
			}	
		s.setStuClass(request.getParameter("stuClass"));
		s.setStuCounsellor(request.getParameter("stuCounsellor"));
		s.setStuId(request.getParameter("stuId"));
		s.setStuPhone(request.getParameter("stuPhone"));
		s.setStuSex(request.getParameter("stuSex"));
		s.setStuSource(request.getParameter("stuSource"));
		UserInfo user = new UserInfo();
		System.out.println(s);
		user.setUId(request.getParameter("stuId"));
		user.setUPassword("123456");
		System.out.println(user.getUId());
		System.out.println(user.getUPassword());
		s.setUserInfo(user);
		adao.addUser(user);
		adao.addStudent(s);
		return "stu_add";
	}
	//修改学生资料
	public String stumodify() {
		System.out.println("stumodify 被调用..................");
		String sid=request.getParameter("sid");
		StuInfo s=adao.queryStudentsByid(sid);
		session.setAttribute("modify_students", s);
		return "stu_modify";
	}
	
	//保存修改添加的学生资料
	public String stusave(){
		System.out.println("stusave 被调用..................");
		StuInfo s =new StuInfo();
		s.setStuAddr(request.getParameter("stuAddr"));
		s.setStuName(request.getParameter("stuName"));
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String aString=request.getParameter("stuBirth");
		Date date=null;
		try { 
			date = sdf.parse(aString); 
			s.setStuBirth(date);
		}catch (ParseException e) { 
			e.printStackTrace();
			}	

		s.setStuClass(request.getParameter("stuClass"));
		s.setStuCounsellor(request.getParameter("stuCounsellor"));
		s.setStuId(request.getParameter("stuId"));
		s.setStuPhone(request.getParameter("stuPhone"));
		s.setStuSex(request.getParameter("stuSex"));
		s.setStuSource(request.getParameter("stuSource"));
		adao.updateStudent(s);
		return "stu_save";
		
	}
	
	//查询教师资料
	public String teaquery()throws Exception{
		System.out.println("teaquery 被调用..................");
		List<TeacherInfo> list=adao.queryAllTeacher();
		if(list!=null&&list.size()>0){
			session.setAttribute("teacherlist",list);
		}
		return "tea_query";
	}
	
	//删除教师资料
	public String teadelete()throws Exception{
		System.out.println("teadelete 被调用..................");
		String tid=request.getParameter("tid");
		adao.deleteTeacher(tid);	
		adao.deleteUser(tid);
		return "tea_delete";
	}
	
	//添加教师资料
	public String teaadd() {
		System.out.println("stuadd 被调用..................");
		TeacherInfo t =new TeacherInfo();
		t.setTCollege(request.getParameter("TCollege"));
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String aString=request.getParameter("TDate");
		Date date=null;
		try { 
			date = sdf.parse(aString); 
			t.setTDate(date);
		}catch (ParseException e) { 
			e.printStackTrace();
			}	
		
		t.setTeacherId(request.getParameter("teacherId"));
		t.setTJobTitle(request.getParameter("TJobTitle"));
		t.setTName(request.getParameter("TName"));
		t.setTPhone(request.getParameter("TPhone"));
		t.setTSex(request.getParameter("TSex"));

		UserInfo u = new UserInfo();
		u.setUId(t.getTeacherId());
		u.setUPassword("123456");
		t.setUserInfo(u);
		adao.addUser(u);	
		adao.addTeacher(t);
		return "tea_add";
	}
	//修改教师资料
	public String teamodify() {
		System.out.println("teamodify 被调用..................");
		String tid=request.getParameter("tid");
		TeacherInfo t=adao.queryTeacherByid(tid);
		session.setAttribute("modify_teachers", t);
		return "tea_modify";
	}
	
	//保存修改和添加的教师资料
	public String teasave(){
		TeacherInfo t =new TeacherInfo();
		t.setTCollege(request.getParameter("TCollege"));
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String aString=request.getParameter("TDate");
		Date date=null;
		try { 
			date = sdf.parse(aString); 
			t.setTDate(date);
		}catch (ParseException e) { 
			e.printStackTrace();
			}	
		
		t.setTeacherId(request.getParameter("teacherId"));
		t.setTJobTitle(request.getParameter("TJobTitle"));
		t.setTName(request.getParameter("TName"));
		t.setTPhone(request.getParameter("TPhone"));
		t.setTSex(request.getParameter("TSex"));
		adao.updateTeacher(t);
		return "tea_save";
		
	}
	
	//培养计划，下拉列表学院的获取
	public String collagelist() {
		List<MajorInfo> list=adao.queryAllCollege();
		if(list!=null&&list.size()>0){
			session.setAttribute("college",list);
		}
		return "college_list";
	}
	
	//培养计划，下拉列表专业的获取，并将已选择的学院显示在文本框中
	public String majorlist() {		
		String majorid=request.getParameter("majorid");
		System.out.println(majorid+"majorid 被调用..................");
		String collegeid=majorid.substring(majorid.length()-4,majorid.length()-2);
		System.out.println(collegeid+"collegeid 被调用..................");
					
		List<MajorInfo> list=adao.queryMajorByCollege(collegeid);
		if(list!=null&&list.size()>0){
			session.setAttribute("majorlist",list);
		}
						
		return "major_list";
	}
	//培养计划，下拉列表其他值的获取，并将已选择的专业显示在文本框中
	public String elselist() {		
		String majorid=request.getParameter("majorid");
		System.out.println(majorid+"majorid 被调用..................");
					
		List<MajorInfo> list=adao.queryEntityById(majorid);
		if(list!=null&&list.size()>0){
			session.setAttribute("entitylist",list);
		}
						
		return "else_list";
	}
	
	//添加培养计划
	public String TrainPlanAdd() {	
		TrainPlan t = new TrainPlan();
		t.setPlanId(request.getParameter("planId"));		
		t.setTrainLevel(request.getParameter("trainLevel"));
		t.setTrainProgram(request.getParameter("trainProgram"));
		t.setGrade(request.getParameter("grade"));
				
		String majorId=request.getParameter("majorId");
		
		MajorInfo m =adao.queryEntityById2(majorId);
		t.setCollege(m.getCollege());
		t.setMajor(m.getMajorName());
		t.setDegree(m.getGrade());
		
		adao.addTrainPlan(t);	

		return "add_trainplan_success";
	}
	
	//查询所有培养计划
	public String queryPYList() {
		System.out.println("queryPYList 被调用..................");
//		List<TrainPlan> list=mpdao.queryAllPYList();
		List<TrainPlan> list=adao.queryAllPYList();
		if(list!=null&&list.size()>0){
			session.setAttribute("PY_title",list);
		}
		return "PY_query";
	}	
	
	//学院专业查询
	public String majorquery() {
		System.out.println("majorquery 被调用..................");
		List<MajorInfo> list=adao.queryAllMajor();
		if(list!=null&&list.size()>0){
			session.setAttribute("majlist",list);
		}
		return "major_query";
	}
	
	//添加学院专业
	public String majoradd() {
		System.out.println("majoradd 被调用..................");
		MajorInfo m =new MajorInfo();
		m.setMajorId(request.getParameter("majorId"));
		m.setCollege(request.getParameter("college"));
		m.setMajorName(request.getParameter("majorName"));
		m.setGrade(request.getParameter("grade"));
		
		adao.addMajor(m);
		return "major_add";
	}
	
	//修改学院专业
	public String majormodify() {
		System.out.println("majormodify 被调用..................");
		String mid=request.getParameter("mid");
		MajorInfo m=adao.queryMajorByid(mid);
		session.setAttribute("modify_majors", m);
		return "major_modify";
	}	
	//保存修改和添加的学院专业信息
	public String majorsave(){
		MajorInfo m =new MajorInfo();
		m.setMajorId(request.getParameter("majorId"));
		m.setCollege(request.getParameter("college"));
		m.setMajorName(request.getParameter("majorName"));
		m.setGrade(request.getParameter("grade"));
		
		adao.updateMajor(m);
		return "major_save";
		
	}
	//删除学院专业信息
	public String majordelete() {
		String mid=request.getParameter("mid");
		adao.deleteMajor(mid);
		return "major_delete";
	}
	
	//查询教学公告
	public String annoquery() {
		System.out.println("annoquery 被调用..................");
		List<TeachingAnno> list=adao.queryAllAnno();
		if(list!=null&&list.size()>0){
			session.setAttribute("annolist",list);
		}
		return "anno_query";
	}
	//添加教学公告
	public String annoadd() {
		System.out.println("annoadd 被调用..................");
		TeachingAnno a =new TeachingAnno();
		//a.setTAnnoId(request.getParameter("TAnnoId"));
		a.setTitle(request.getParameter("title"));
		a.setDetail(request.getParameter("detail"));
		a.setPublishDapartment(request.getParameter("publishDapartment"));		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = sdf.format(new Date());
		Date time=null;
		try { 
			time = sdf.parse(d); 
			a.setPublishTime(time);
		}catch (ParseException e) { 
			e.printStackTrace();
		}
		adao.addAnno(a);
		return "anno_add";
	}
	//删除教学公告
	public String annodelete() {
		Integer aid=Integer.parseInt(request.getParameter("aid"));
		adao.deleteAnno(aid);
		return "anno_delete";
	}	
	
	//查询招聘信息
	public String recruquery() {
		System.out.println("recruquery 被调用..................");
		List<RecruitmentInfo> list=adao.queryAllRecruitment();
		if(list!=null&&list.size()>0){
			session.setAttribute("recrulist",list);
		}
		return "recru_query";
	}
	//添加招聘信息
	public String recruadd() {
		System.out.println("recruadd 被调用..................");
		RecruitmentInfo r =new RecruitmentInfo();
		//r.setRecruId(request.getParameter("recruId"));
		r.setRecruTitle(request.getParameter("recruTitle"));
		r.setRecruType(request.getParameter("recruType"));		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String aString=request.getParameter("recruDate");
		Date date=null;
		try { 
			date = sdf.parse(aString); 
			r.setRecruDate(date);
		}catch (ParseException e) { 
			e.printStackTrace();
			}		
		r.setRecruDetail(request.getParameter("recruDetail"));		
		adao.addRecru(r);
		return "recru_add";
	}
	
	//删除招聘信息
	public String recrudelete() {
		System.out.println("recrudelete 被调用..................");
		Integer rid=Integer.parseInt(request.getParameter("rid"));
		System.out.println(rid+"rid被调用..................");
		adao.deleteRecru(rid);
		return "recru_delete";	
	}
	
	
}
