//��ʦ��½��ɽ��пγ̿��裬�鿴������Ϣ��¼��ɼ���
package action;

import java.util.ArrayList;
import java.util.List;

import service.StudentDAO;
import service.TeacherDAO;

import entity.CourseInfo;
import entity.ScoreInfo;
import entity.ScoreInfoId;
import entity.StuInfo;
import entity.TeacherInfo;

public class TeacherAction extends SuperAction {

	private static final long serialVersionUID = 1L;
	private TeacherDAO tdao;
	public void setteacherDAO(TeacherDAO teacherDAO){
		this.tdao=teacherDAO;
	}
	
	private StudentDAO sdao;
	public void setstudentDAO(StudentDAO studentDAO){

		this.sdao=studentDAO;
	}
	
//��ʾ������Ϣ
	public String query(){
		System.out.println("query����");
		String tid=request.getParameter("tid");
		TeacherInfo t=tdao.queryTeacherByid(tid);
		session.setAttribute("my_Info", t);
		return "query_info";

	}
	

	//��ʾ�γ���Ϣ
	private CourseInfo c = new CourseInfo();
	public String coursequery() {
		System.out.println("coursequery ������..................");
		List<CourseInfo> list=tdao.queryAllCourse();
		List<TeacherInfo> listc=new ArrayList<TeacherInfo>();
		for(int i = 0 ; i < list.size() ; i++) {
			CourseInfo attribute= list.get(i);
			TeacherInfo t = attribute.getTeacherInfo();
			String tid = t.getTeacherId();
			TeacherInfo sto=tdao.queryTeacherByid(tid);
			listc.add(sto);	
			}
		if(list!=null&&list.size()>0){
			session.setAttribute("courselist",list);
			session.setAttribute("tea_name",listc);
		}	
		return "course_query";
	}
	
	
	//��ӿγ�
	public String courseAdd() {
		System.out.println("courseadd ������..................");
		String tid= request.getParameter("tid");
		TeacherInfo tea = tdao.queryTeacherByid(tid);
		c.setCourseId(request.getParameter("courseId"));	
		c.setTeacherInfo(tea);
		c.setCourseName(request.getParameter("courseName"));
		c.setCourseCredit(Float.parseFloat(request.getParameter("courseCredit")));
		c.setCourseType(request.getParameter("courseType"));
		c.setCoursePeriod(Integer.parseInt(request.getParameter("coursePeriod")));
		c.setCourseTimeAddr(request.getParameter("courseTimeAddr"));
		tdao.addCourse(c);
		return "course_add";
	}
	
	
	//��ʾ�οεĿγ���Ϣ
		public String courselist() {
			System.out.println("coursequery ������..................");
			String tid=request.getParameter("tid");
			TeacherInfo t=tdao.queryTeacherByid(tid);
			List<CourseInfo> list=tdao.queryCoursebytid(t);
			if(list!=null&&list.size()>0){
				session.setAttribute("courselist",list);
			}
			return "Course_mylist";
		}
		
	//��ӳɼ�
	public String scoreAdd(){
		System.out.println("scoreAdd ������..................");
		String cid=request.getParameter("cid");
		CourseInfo c=sdao.queryCourseByid(cid);
		session.setAttribute("stu_course", c);
		List<ScoreInfo> list=tdao.findStuByCid(cid);
		
		List<StuInfo> listc=new ArrayList<StuInfo>();
		for(int i = 0 ; i < list.size() ; i++) {
			ScoreInfo attribute= list.get(i);
			StuInfo s= attribute.getStuInfo();
			String sid =s.getStuId();
			StuInfo sto=sdao.queryStudentsByid(sid);
			listc.add(sto);	
		}
		if(list!=null&&list.size()>0){
			session.setAttribute("stu_score",list);
			session.setAttribute("stu_name",listc);
		}
		return "Score_add";
	}
	
	//����ɼ�
	public String saveScore(){
		System.out.println("saveScore ������..................");
		int size=Integer.parseInt(request.getParameter("size"));
		for(int i = 0 ; i < size ; i++) {
			String score="scoreInfos["+i+"].score";
			score=request.getParameter(score);
			
			String stu="scoreInfos["+i+"].stuId";
			System.out.println(request.getParameter(stu));
			StuInfo s=sdao.queryStudentsByid(request.getParameter(stu));
			System.out.println(s.getStuId());
			
			String cou="scoreInfos["+i+"].courseId";
			System.out.println(request.getParameter(cou));
			CourseInfo c=sdao.queryCourseByid(request.getParameter(cou));
			System.out.println(c);
			
			String cid=c.getCourseId();
			ScoreInfoId scoreid =new ScoreInfoId();
			scoreid.setCourId(cid);
			scoreid.setSId(s.getStuId());
			request.setAttribute("cid",cid);
			
			ScoreInfo sco= new ScoreInfo();
			sco.setId(scoreid);
			sco.setScore(score);
			sco.setCourseInfo(c);
			sco.setStuInfo(s);
			tdao.updateScore(sco);
		}
		return "Score_save";
	}
	
	//�鿴�ɼ�
	public String quaryscore() {
		System.out.println("quaryscore ������..................");
		String cid=request.getParameter("cid");
		if(cid == null){
			cid = (String) request.getAttribute("cid");
		}
		
		System.out.println(cid);
		
		CourseInfo c=sdao.queryCourseByid(cid);
		session.setAttribute("stu_course", c.getCourseName());
		List<ScoreInfo> list=tdao.findStuByCid(cid);
		
		List<String> listc=new ArrayList<String>();
		for(int i = 0 ; i < list.size() ; i++) {
			ScoreInfo attribute= list.get(i);
			StuInfo s= attribute.getStuInfo();
			String sid =s.getStuId();
			String name=sdao.queryStudentsByid(sid).getStuName();
			listc.add(name);	
		}
		if(list!=null&&list.size()>0){
			session.setAttribute("stu_score",list);
			session.setAttribute("stu_name",listc);
		}
		return "score_quary";
	}
	

	


}
