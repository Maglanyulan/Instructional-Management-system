package entity;

/**
 * ScoreInfo entity. @author MyEclipse Persistence Tools
 */

public class ScoreInfo implements java.io.Serializable {

	// Fields

	private ScoreInfoId id;
	private StuInfo stuInfo;
	private CourseInfo courseInfo;
	private String score;

	// Constructors

	/** default constructor */
	public ScoreInfo() {
	}

	/** minimal constructor */
	public ScoreInfo(ScoreInfoId id, StuInfo stuInfo, CourseInfo courseInfo) {
		this.id = id;
		this.stuInfo = stuInfo;
		this.courseInfo = courseInfo;
	}

	/** full constructor */
	public ScoreInfo(ScoreInfoId id, StuInfo stuInfo, CourseInfo courseInfo,
			String score) {
		this.id = id;
		this.stuInfo = stuInfo;
		this.courseInfo = courseInfo;
		this.score = score;
	}

	// Property accessors

	public ScoreInfoId getId() {
		return this.id;
	}

	public void setId(ScoreInfoId id) {
		this.id = id;
	}

	public StuInfo getStuInfo() {
		return this.stuInfo;
	}

	public void setStuInfo(StuInfo stuInfo) {
		this.stuInfo = stuInfo;
	}

	public CourseInfo getCourseInfo() {
		return this.courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}