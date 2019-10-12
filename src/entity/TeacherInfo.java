package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TeacherInfo entity. @author MyEclipse Persistence Tools
 */

public class TeacherInfo implements java.io.Serializable {

	// Fields

	private String teacherId;
	private UserInfo userInfo;
	private String TName;
	private String TSex;
	private Date TDate;
	private String TCollege;
	private String TJobTitle;
	private String TPhone;
	private Set courseInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TeacherInfo() {
	}

	/** minimal constructor */
	public TeacherInfo(UserInfo userInfo, String TName, String TSex,
			Date TDate, String TCollege, String TJobTitle, String TPhone) {
		this.userInfo = userInfo;
		this.TName = TName;
		this.TSex = TSex;
		this.TDate = TDate;
		this.TCollege = TCollege;
		this.TJobTitle = TJobTitle;
		this.TPhone = TPhone;
	}

	/** full constructor */
	public TeacherInfo(UserInfo userInfo, String TName, String TSex,
			Date TDate, String TCollege, String TJobTitle, String TPhone,
			Set courseInfos) {
		this.userInfo = userInfo;
		this.TName = TName;
		this.TSex = TSex;
		this.TDate = TDate;
		this.TCollege = TCollege;
		this.TJobTitle = TJobTitle;
		this.TPhone = TPhone;
		this.courseInfos = courseInfos;
	}

	// Property accessors

	public String getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getTName() {
		return this.TName;
	}

	public void setTName(String TName) {
		this.TName = TName;
	}

	public String getTSex() {
		return this.TSex;
	}

	public void setTSex(String TSex) {
		this.TSex = TSex;
	}

	public Date getTDate() {
		return this.TDate;
	}

	public void setTDate(Date TDate) {
		this.TDate = TDate;
	}

	public String getTCollege() {
		return this.TCollege;
	}

	public void setTCollege(String TCollege) {
		this.TCollege = TCollege;
	}

	public String getTJobTitle() {
		return this.TJobTitle;
	}

	public void setTJobTitle(String TJobTitle) {
		this.TJobTitle = TJobTitle;
	}

	public String getTPhone() {
		return this.TPhone;
	}

	public void setTPhone(String TPhone) {
		this.TPhone = TPhone;
	}

	public Set getCourseInfos() {
		return this.courseInfos;
	}

	public void setCourseInfos(Set courseInfos) {
		this.courseInfos = courseInfos;
	}

}