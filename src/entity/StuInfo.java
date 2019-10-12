package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * StuInfo entity. @author MyEclipse Persistence Tools
 */

public class StuInfo implements java.io.Serializable {

	// Fields

	private String stuId;
	private UserInfo userInfo;
	private String stuName;
	private String stuSex;
	private Date stuBirth;
	private String stuClass;
	private String stuSource;
	private String stuCounsellor;
	private String stuPhone;
	private String stuAddr;
	private Set scoreInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public StuInfo() {
	}

	/** minimal constructor */
	public StuInfo(UserInfo userInfo, String stuName, String stuSex,
			Date stuBirth, String stuClass, String stuSource,
			String stuCounsellor, String stuPhone, String stuAddr) {
		this.userInfo = userInfo;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuBirth = stuBirth;
		this.stuClass = stuClass;
		this.stuSource = stuSource;
		this.stuCounsellor = stuCounsellor;
		this.stuPhone = stuPhone;
		this.stuAddr = stuAddr;
	}

	/** full constructor */
	public StuInfo(UserInfo userInfo, String stuName, String stuSex,
			Date stuBirth, String stuClass, String stuSource,
			String stuCounsellor, String stuPhone, String stuAddr,
			Set scoreInfos) {
		this.userInfo = userInfo;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuBirth = stuBirth;
		this.stuClass = stuClass;
		this.stuSource = stuSource;
		this.stuCounsellor = stuCounsellor;
		this.stuPhone = stuPhone;
		this.stuAddr = stuAddr;
		this.scoreInfos = scoreInfos;
	}

	// Property accessors

	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return this.stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public Date getStuBirth() {
		return this.stuBirth;
	}

	public void setStuBirth(Date stuBirth) {
		this.stuBirth = stuBirth;
	}

	public String getStuClass() {
		return this.stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public String getStuSource() {
		return this.stuSource;
	}

	public void setStuSource(String stuSource) {
		this.stuSource = stuSource;
	}

	public String getStuCounsellor() {
		return this.stuCounsellor;
	}

	public void setStuCounsellor(String stuCounsellor) {
		this.stuCounsellor = stuCounsellor;
	}

	public String getStuPhone() {
		return this.stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuAddr() {
		return this.stuAddr;
	}

	public void setStuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}

	public Set getScoreInfos() {
		return this.scoreInfos;
	}

	public void setScoreInfos(Set scoreInfos) {
		this.scoreInfos = scoreInfos;
	}

}