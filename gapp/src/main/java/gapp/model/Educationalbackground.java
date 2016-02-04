package gapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * This model will contain all the records of the User's Education Background Degree. Applications
 * will contain the Educational Background.
 * 
 */

@Entity
@Table(name = "educationalbackground")
public class Educationalbackground implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Basic
	@Column(name="university")
	String university;
	
	@Basic
    @Column(name="degree")
	String degree;

	@Basic
    @Column(name="major")
	String major;
	
	/*
	 *  The year Degree was earned.
	 */
	Date year;

	/* List of all Applications */
	@ManyToOne
	Applications applicationsdegree;

	public Educationalbackground() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Applications getApplicationsdegree() {
		return applicationsdegree;
	}

	public void setApplicationsdegree(Applications applicationsdegree) {
		this.applicationsdegree = applicationsdegree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

}
