package entity;

/**
 * ScoreInfoId entity. @author MyEclipse Persistence Tools
 */

public class ScoreInfoId implements java.io.Serializable {

	// Fields

	private String SId;
	private String courId;

	// Constructors

	/** default constructor */
	public ScoreInfoId() {
	}

	/** full constructor */
	public ScoreInfoId(String SId, String courId) {
		this.SId = SId;
		this.courId = courId;
	}

	// Property accessors

	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

	public String getCourId() {
		return this.courId;
	}

	public void setCourId(String courId) {
		this.courId = courId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ScoreInfoId))
			return false;
		ScoreInfoId castOther = (ScoreInfoId) other;

		return ((this.getSId() == castOther.getSId()) || (this.getSId() != null
				&& castOther.getSId() != null && this.getSId().equals(
				castOther.getSId())))
				&& ((this.getCourId() == castOther.getCourId()) || (this
						.getCourId() != null && castOther.getCourId() != null && this
						.getCourId().equals(castOther.getCourId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSId() == null ? 0 : this.getSId().hashCode());
		result = 37 * result
				+ (getCourId() == null ? 0 : this.getCourId().hashCode());
		return result;
	}

}