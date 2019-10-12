package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private String UId;
	private String UPassword;
	private Set teacherInfos = new HashSet(0);
	private Set stuInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String UPassword) {
		this.UPassword = UPassword;
	}

	/** full constructor */
	public UserInfo(String UPassword, Set teacherInfos, Set stuInfos) {
		this.UPassword = UPassword;
		this.teacherInfos = teacherInfos;
		this.stuInfos = stuInfos;
	}

	// Property accessors

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getUPassword() {
		return this.UPassword;
	}

	public void setUPassword(String UPassword) {
		this.UPassword = UPassword;
	}

	public Set getTeacherInfos() {
		return this.teacherInfos;
	}

	public void setTeacherInfos(Set teacherInfos) {
		this.teacherInfos = teacherInfos;
	}

	public Set getStuInfos() {
		return this.stuInfos;
	}

	public void setStuInfos(Set stuInfos) {
		this.stuInfos = stuInfos;
	}

}