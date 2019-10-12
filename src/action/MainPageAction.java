/*
 * �ṩ����չʾ����չʾ��̨�����Ľ�ѧ���棻
 * �ṩ��ҵ��Ƹ��Ϣչʾ��
 * �ṩ��ѧԺ��רҵ���꼶�������ƻ���
 */

package action;

import java.util.List;

import service.AdminDAO;
import service.MainPageDAO;

import entity.RecruitmentInfo;
import entity.ScoreInfo;
import entity.StuInfo;
import entity.TeachingAnno;
import entity.TrainPlan;

public class MainPageAction extends SuperAction{
	private static final long serialVersionUID = 1L;
	
	private MainPageDAO mpdao;
	public void setmainpageDAO(MainPageDAO mpdao){
		this.mpdao=mpdao;
	}
	//��ȡ��ѧ�����б�
	public String getJXList() {
		System.out.println("getJXList ������..................");
		List<TeachingAnno> list=mpdao.queryAllJXList();
		if(list!=null&&list.size()>0){
			session.setAttribute("JXtitle",list);
		}
		return "loginpage_JX";	
	}
	
	//��ȡ��ѧ��������
	public String getJXContent() {
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id+"id ������..................");
		List<TeachingAnno> list=mpdao.findJXContentByCid(id);
		if(list!=null&&list.size()>0){
			session.setAttribute("JXContext",list);
		}
		return "loginpage_JX_context";	
	}
	//��ȡ��Ƹ��Ϣ�б�
	public String getZPList() {
		System.out.println("getZPList ������..................");
		List<RecruitmentInfo> list=mpdao.queryAllZPList();
		if(list!=null&&list.size()>0){
			session.setAttribute("ZPtitle",list);
		}
		return "loginpage_ZP";	
	}
	//��ȡ��Ƹ��Ϣ����
	public String getZPContent() {
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id+"id ������..................");
		List<RecruitmentInfo> list=mpdao.findZPContentByCid(id);
		if(list!=null&&list.size()>0){
			session.setAttribute("ZPContext",list);
		}
		return "loginpage_ZP_context";	
	}
	//��ȡ�����ƻ�����
	public String getPYContent() {
		String id=request.getParameter("id");
		System.out.println(id+"id ������..................");
		List<TrainPlan> list=mpdao.findPYContentByCid(id);
		if(list!=null&&list.size()>0){
			session.setAttribute("PYContext",list);
		}
		return "loginpage_PY_context";	
	}
	//���ݹؼ��ֲ��������ƻ�
	public String searchPYTitle() {
		String SEARCH=request.getParameter("search");
		System.out.println(SEARCH+"SEARCH ������..................");
		List<TrainPlan> list=mpdao.findPYTitleBySearch(SEARCH);
		if(list!=null&&list.size()>0){
			session.setAttribute("PYBySeaTitle",list);
		}else{
			session.removeAttribute("PYBySeaTitle");
		}
		return "loginpage_PY_title";	
	}
	//��ѯ�����ƻ��б�
	public String getPYList() {
		List<TrainPlan> list=mpdao.queryAllPYList();
		if(list!=null&&list.size()>0){
			session.setAttribute("PYtitle",list);
		}
		return "loginpage_PY";
	}
	
}
