/*
 * 提供公告展示栏，展示后台发布的教学公告；
 * 提供企业招聘信息展示；
 * 提供各学院、专业及年级的培养计划；
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
	//获取教学公告列表
	public String getJXList() {
		System.out.println("getJXList 被调用..................");
		List<TeachingAnno> list=mpdao.queryAllJXList();
		if(list!=null&&list.size()>0){
			session.setAttribute("JXtitle",list);
		}
		return "loginpage_JX";	
	}
	
	//获取教学公告内容
	public String getJXContent() {
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id+"id 被调用..................");
		List<TeachingAnno> list=mpdao.findJXContentByCid(id);
		if(list!=null&&list.size()>0){
			session.setAttribute("JXContext",list);
		}
		return "loginpage_JX_context";	
	}
	//获取招聘信息列表
	public String getZPList() {
		System.out.println("getZPList 被调用..................");
		List<RecruitmentInfo> list=mpdao.queryAllZPList();
		if(list!=null&&list.size()>0){
			session.setAttribute("ZPtitle",list);
		}
		return "loginpage_ZP";	
	}
	//获取招聘信息内容
	public String getZPContent() {
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id+"id 被调用..................");
		List<RecruitmentInfo> list=mpdao.findZPContentByCid(id);
		if(list!=null&&list.size()>0){
			session.setAttribute("ZPContext",list);
		}
		return "loginpage_ZP_context";	
	}
	//获取培养计划内容
	public String getPYContent() {
		String id=request.getParameter("id");
		System.out.println(id+"id 被调用..................");
		List<TrainPlan> list=mpdao.findPYContentByCid(id);
		if(list!=null&&list.size()>0){
			session.setAttribute("PYContext",list);
		}
		return "loginpage_PY_context";	
	}
	//根据关键字查找培养计划
	public String searchPYTitle() {
		String SEARCH=request.getParameter("search");
		System.out.println(SEARCH+"SEARCH 被调用..................");
		List<TrainPlan> list=mpdao.findPYTitleBySearch(SEARCH);
		if(list!=null&&list.size()>0){
			session.setAttribute("PYBySeaTitle",list);
		}else{
			session.removeAttribute("PYBySeaTitle");
		}
		return "loginpage_PY_title";	
	}
	//查询培养计划列表
	public String getPYList() {
		List<TrainPlan> list=mpdao.queryAllPYList();
		if(list!=null&&list.size()>0){
			session.setAttribute("PYtitle",list);
		}
		return "loginpage_PY";
	}
	
}
