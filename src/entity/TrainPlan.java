package entity;

/**
 * TrainPlan entity. @author MyEclipse Persistence Tools
 */

public class TrainPlan implements java.io.Serializable {

	// Fields

	private String planId;
	private String college;
	private String grade;
	private String major;
	private String trainLevel;
	private String degree;
	private String trainProgram;

	// Constructors

	/** default constructor */
	public TrainPlan() {
	}

	/** full constructor */
	public TrainPlan(String college, String grade, String major,
			String trainLevel, String degree, String trainProgram) {
		this.college = college;
		this.grade = grade;
		this.major = major;
		this.trainLevel = trainLevel;
		this.degree = degree;
		this.trainProgram = trainProgram;
	}

	// Property accessors

	public String getPlanId() {
		return this.planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTrainLevel() {
		return this.trainLevel;
	}

	public void setTrainLevel(String trainLevel) {
		this.trainLevel = trainLevel;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTrainProgram() {
		return this.trainProgram;
	}

	public void setTrainProgram(String trainProgram) {
		this.trainProgram = trainProgram;
	}

}