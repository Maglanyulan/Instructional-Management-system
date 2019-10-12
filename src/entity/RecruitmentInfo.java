package entity;

import java.util.Date;

/**
 * RecruitmentInfo entity. @author MyEclipse Persistence Tools
 */

public class RecruitmentInfo implements java.io.Serializable {

	// Fields

	private Integer recruId;
	private String recruTitle;
	private String recruType;
	private Date recruDate;
	private String recruDetail;

	// Constructors

	/** default constructor */
	public RecruitmentInfo() {
	}

	/** full constructor */
	public RecruitmentInfo(String recruTitle, String recruType, Date recruDate,
			String recruDetail) {
		this.recruTitle = recruTitle;
		this.recruType = recruType;
		this.recruDate = recruDate;
		this.recruDetail = recruDetail;
	}

	// Property accessors

	public Integer getRecruId() {
		return this.recruId;
	}

	public void setRecruId(Integer recruId) {
		this.recruId = recruId;
	}

	public String getRecruTitle() {
		return this.recruTitle;
	}

	public void setRecruTitle(String recruTitle) {
		this.recruTitle = recruTitle;
	}

	public String getRecruType() {
		return this.recruType;
	}

	public void setRecruType(String recruType) {
		this.recruType = recruType;
	}

	public Date getRecruDate() {
		return this.recruDate;
	}

	public void setRecruDate(Date recruDate) {
		this.recruDate = recruDate;
	}

	public String getRecruDetail() {
		return this.recruDetail;
	}

	public void setRecruDetail(String recruDetail) {
		this.recruDetail = recruDetail;
	}

}