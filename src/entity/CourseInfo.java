package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * CourseInfo entity. @author MyEclipse Persistence Tools
 */

public class CourseInfo implements java.io.Serializable {

	// Fields

	private String courseId;
	private TeacherInfo teacherInfo;
	private String courseName;
	private float courseCredit;
	private String courseType;
	private Integer coursePeriod;
	private String courseTimeAddr;
	private Set scoreInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public CourseInfo() {
	}

	/** minimal constructor */
	public CourseInfo(TeacherInfo teacherInfo, String courseName,
			float courseCredit, String courseType, Integer coursePeriod,
			String courseTimeAddr) {
		this.teacherInfo = teacherInfo;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseType = courseType;
		this.coursePeriod = coursePeriod;
		this.courseTimeAddr = courseTimeAddr;
	}

	/** full constructor */
	public CourseInfo(TeacherInfo teacherInfo, String courseName,
			float courseCredit, String courseType, Integer coursePeriod,
			String courseTimeAddr, Set scoreInfos) {
		this.teacherInfo = teacherInfo;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseType = courseType;
		this.coursePeriod = coursePeriod;
		this.courseTimeAddr = courseTimeAddr;
		this.scoreInfos = scoreInfos;
	}

	// Property accessors

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public TeacherInfo getTeacherInfo() {
		return this.teacherInfo;
	}

	public void setTeacherInfo(TeacherInfo teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public float getCourseCredit() {
		return this.courseCredit;
	}

	public void setCourseCredit(float courseCredit) {
		this.courseCredit = courseCredit;
	}

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public Integer getCoursePeriod() {
		return this.coursePeriod;
	}

	public void setCoursePeriod(Integer coursePeriod) {
		this.coursePeriod = coursePeriod;
	}

	public String getCourseTimeAddr() {
		return this.courseTimeAddr;
	}

	public void setCourseTimeAddr(String courseTimeAddr) {
		this.courseTimeAddr = courseTimeAddr;
	}

	public Set getScoreInfos() {
		return this.scoreInfos;
	}

	public void setScoreInfos(Set scoreInfos) {
		this.scoreInfos = scoreInfos;
	}

}