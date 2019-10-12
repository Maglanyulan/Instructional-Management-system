 /*
  * �������Ա��½��ɶ�ϵͳ���й���
  * �������棬��ѯ���޸�����ѧ��/��ʦ����Ϣ��
  * ��ѧԺ��רҵ��Ϣ�����޸ĵȹ��ܣ�
  * �ṩ�����ƻ����ģ�飬�ɰ�ѧԺ��רҵ���꼶�ķ���¼�������ƻ�;
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
		System.out.println("setadminDAO ������..................");
		this.adao=adminDAO;
	}
	
	
	//��ѯѧ������
	public String stuquery() {
		System.out.println("stuquery ������..................");
		List<StuInfo> list=adao.queryAllStudent();
		if(list!=null&&list.size()>0){
			session.setAttribute("studentlist",list);
		}
		return "stu_query";
	}
	
	//ɾ��ѧ������
	public String studelete() {
		String sid=request.getParameter("sid");
		System.out.println(sid);
		adao.deleteStudent(sid);
		adao.deleteUser(sid);
		return "stu_delete";
	}
	
	//���ѧ������
	public String stuadd() {
		System.out.println("stuadd ������..................");
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
	//�޸�ѧ������
	public String stumodify() {
		System.out.println("stumodify ������..................");
		String sid=request.getParameter("sid");
		StuInfo s=adao.queryStudentsByid(sid);
		session.setAttribute("modify_students", s);
		return "stu_modify";
	}
	
	//�����޸���ӵ�ѧ������
	public String stusave(){
		System.out.println("stusave ������..................");
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
	
	//��ѯ��ʦ����
	public String teaquery()throws Exception{
		System.out.println("teaquery ������..................");
		List<TeacherInfo> list=adao.queryAllTeacher();
		if(list!=null&&list.size()>0){
			session.setAttribute("teacherlist",list);
		}
		return "tea_query";
	}
	
	//ɾ����ʦ����
	public String teadelete()throws Exception{
		System.out.println("teadelete ������..................");
		String tid=request.getParameter("tid");
		adao.deleteTeacher(tid);	
		adao.deleteUser(tid);
		return "tea_delete";
	}
	
	//��ӽ�ʦ����
	public String teaadd() {
		System.out.println("stuadd ������..................");
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
	//�޸Ľ�ʦ����
	public String teamodify() {
		System.out.println("teamodify ������..................");
		String tid=request.getParameter("tid");
		TeacherInfo t=adao.queryTeacherByid(tid);
		session.setAttribute("modify_teachers", t);
		return "tea_modify";
	}
	
	//�����޸ĺ���ӵĽ�ʦ����
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
	
	//�����ƻ��������б�ѧԺ�Ļ�ȡ
	public String collagelist() {
		List<MajorInfo> list=adao.queryAllCollege();
		if(list!=null&&list.size()>0){
			session.setAttribute("college",list);
		}
		return "college_list";
	}
	
	//�����ƻ��������б�רҵ�Ļ�ȡ��������ѡ���ѧԺ��ʾ���ı�����
	public String majorlist() {		
		String majorid=request.getParameter("majorid");
		System.out.println(majorid+"majorid ������..................");
		String collegeid=majorid.substring(majorid.length()-4,majorid.length()-2);
		System.out.println(collegeid+"collegeid ������..................");
					
		List<MajorInfo> list=adao.queryMajorByCollege(collegeid);
		if(list!=null&&list.size()>0){
			session.setAttribute("majorlist",list);
		}
						
		return "major_list";
	}
	//�����ƻ��������б�����ֵ�Ļ�ȡ��������ѡ���רҵ��ʾ���ı�����
	public String elselist() {		
		String majorid=request.getParameter("majorid");
		System.out.println(majorid+"majorid ������..................");
					
		List<MajorInfo> list=adao.queryEntityById(majorid);
		if(list!=null&&list.size()>0){
			session.setAttribute("entitylist",list);
		}
						
		return "else_list";
	}
	
	//��������ƻ�
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
	
	//��ѯ���������ƻ�
	public String queryPYList() {
		System.out.println("queryPYList ������..................");
//		List<TrainPlan> list=mpdao.queryAllPYList();
		List<TrainPlan> list=adao.queryAllPYList();
		if(list!=null&&list.size()>0){
			session.setAttribute("PY_title",list);
		}
		return "PY_query";
	}	
	
	//ѧԺרҵ��ѯ
	public String majorquery() {
		System.out.println("majorquery ������..................");
		List<MajorInfo> list=adao.queryAllMajor();
		if(list!=null&&list.size()>0){
			session.setAttribute("majlist",list);
		}
		return "major_query";
	}
	
	//���ѧԺרҵ
	public String majoradd() {
		System.out.println("majoradd ������..................");
		MajorInfo m =new MajorInfo();
		m.setMajorId(request.getParameter("majorId"));
		m.setCollege(request.getParameter("college"));
		m.setMajorName(request.getParameter("majorName"));
		m.setGrade(request.getParameter("grade"));
		
		adao.addMajor(m);
		return "major_add";
	}
	
	//�޸�ѧԺרҵ
	public String majormodify() {
		System.out.println("majormodify ������..................");
		String mid=request.getParameter("mid");
		MajorInfo m=adao.queryMajorByid(mid);
		session.setAttribute("modify_majors", m);
		return "major_modify";
	}	
	//�����޸ĺ���ӵ�ѧԺרҵ��Ϣ
	public String majorsave(){
		MajorInfo m =new MajorInfo();
		m.setMajorId(request.getParameter("majorId"));
		m.setCollege(request.getParameter("college"));
		m.setMajorName(request.getParameter("majorName"));
		m.setGrade(request.getParameter("grade"));
		
		adao.updateMajor(m);
		return "major_save";
		
	}
	//ɾ��ѧԺרҵ��Ϣ
	public String majordelete() {
		String mid=request.getParameter("mid");
		adao.deleteMajor(mid);
		return "major_delete";
	}
	
	//��ѯ��ѧ����
	public String annoquery() {
		System.out.println("annoquery ������..................");
		List<TeachingAnno> list=adao.queryAllAnno();
		if(list!=null&&list.size()>0){
			session.setAttribute("annolist",list);
		}
		return "anno_query";
	}
	//��ӽ�ѧ����
	public String annoadd() {
		System.out.println("annoadd ������..................");
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
	//ɾ����ѧ����
	public String annodelete() {
		Integer aid=Integer.parseInt(request.getParameter("aid"));
		adao.deleteAnno(aid);
		return "anno_delete";
	}	
	
	//��ѯ��Ƹ��Ϣ
	public String recruquery() {
		System.out.println("recruquery ������..................");
		List<RecruitmentInfo> list=adao.queryAllRecruitment();
		if(list!=null&&list.size()>0){
			session.setAttribute("recrulist",list);
		}
		return "recru_query";
	}
	//�����Ƹ��Ϣ
	public String recruadd() {
		System.out.println("recruadd ������..................");
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
	
	//ɾ����Ƹ��Ϣ
	public String recrudelete() {
		System.out.println("recrudelete ������..................");
		Integer rid=Integer.parseInt(request.getParameter("rid"));
		System.out.println(rid+"rid������..................");
		adao.deleteRecru(rid);
		return "recru_delete";	
	}
	
	
}
