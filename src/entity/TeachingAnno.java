package entity;

import java.util.Date;

/**
 * TeachingAnno entity. @author MyEclipse Persistence Tools
 */

public class TeachingAnno implements java.io.Serializable {

	// Fields

	private Integer TAnnoId;
	private String title;
	private String detail;
	private String publishDapartment;
	private Date publishTime;

	// Constructors

	/** default constructor */
	public TeachingAnno() {
	}

	/** full constructor */
	public TeachingAnno(String title, String detail, String publishDapartment,
			Date publishTime) {
		this.title = title;
		this.detail = detail;
		this.publishDapartment = publishDapartment;
		this.publishTime = publishTime;
	}

	// Property accessors

	public Integer getTAnnoId() {
		return this.TAnnoId;
	}

	public void setTAnnoId(Integer TAnnoId) {
		this.TAnnoId = TAnnoId;
		String str = Integer.toString(TAnnoId);
	}
	

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPublishDapartment() {
		return this.publishDapartment;
	}

	public void setPublishDapartment(String publishDapartment) {
		this.publishDapartment = publishDapartment;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	

}