package homework1.model;

import java.util.Date;

/*
 * This is a Bean Class that holds the 
 * Main Display of CS - Graduate Admission 
 * date is the date applied and status is list of statuslst
 * 
 */
public class GradAdmiBean implements Comparable<GradAdmiBean> {

	/*
	 * The Applicant Name is using Name as String date is using Java Date GPA is
	 * using Double Status is using String
	 * 
	 */

	private String applicant;

	private Date date;

	private Double gpa;

	private String status;

	public GradAdmiBean() {
		gpa = null;
		new Date();
	}

	public GradAdmiBean(String applicant, Date date, Double gpa, String status) {

		this.applicant = applicant;
		this.date = date;
		this.gpa = gpa;
		this.status = status;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(GradAdmiBean obj) {

		return this.applicant.compareTo(obj.getApplicant());
	}

	// public int compareToIgnoreCase(GradAdmiBean stats) {
	//
	// return this.status.compareTo(stats.getStatus());
	// }

}
