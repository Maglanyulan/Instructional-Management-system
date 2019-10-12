package entity;

/**
 * MajorInfo entity. @author MyEclipse Persistence Tools
 */

public class MajorInfo implements java.io.Serializable {

	// Fields

	private String majorId;
	private String college;
	private String majorName;
	private String grade;

	// Constructors

	/** default constructor */
	public MajorInfo() {
	}

	/** minimal constructor */
	public MajorInfo(String college, String majorName) {
		this.college = college;
		this.majorName = majorName;
	}

	/** full constructor */
	public MajorInfo(String college, String majorName, String grade) {
		this.college = college;
		this.majorName = majorName;
		this.grade = grade;
	}

	// Property accessors

	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}