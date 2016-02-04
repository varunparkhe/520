package gapp.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * 
 * This is the main Application page for the GAPP to which the User student will submit and
 * Admission Committee and the Staff will review and update.
 * 
 * The Applications will consist of list of Educational Background.
 * 
 * The Application will also consist of list of Program and the Program will consist of Department
 * and Additional Fields.
 * 
 * Finally the Applications will consist of additional fields.
 * 
 */

@Entity
@Table(name = "applications")
public class Applications implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;


    /* Application will consist of all remaining additional fields */


    /* Number integer score for TOEFL marks */
    @Basic
    @Column(name = "toefl")
    Integer toefl;


    /* Number integer for GRE marks */
    @Basic
    @Column(name = "gre")
    Integer gre;


    /* Double value for GPA using decimals */
    @Basic
    @Column(name = "gpa")
    Double gpa;


    /* File Type of byte arrays for file handling */
    File trasncript;


    /* All Types of Users object. */
    @ManyToOne
    User user;


    /* List of all the details of Educational Background */
    @OneToMany(mappedBy = "applicationsdegree", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    List<Educationalbackground> degrees;


    /* Application - Program */
    @ManyToOne
    Programs prog;


    /* Status and list of History of it. */

    @OneToMany(mappedBy = "applicant", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    List<AuditStatus> auditstatus;

    public Applications() {

        gpa = null;

        degrees = new ArrayList<Educationalbackground>();

        auditstatus = new ArrayList<AuditStatus>();

    }

    public Programs getProg() {
        return prog;
    }

    public void setProg(Programs prog) {
        this.prog = prog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToefl() {
        return toefl;
    }

    public void setToefl(Integer toefl) {
        this.toefl = toefl;
    }

    public Integer getGre() {
        return gre;
    }

    public void setGre(Integer gre) {
        this.gre = gre;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public File getTrasncript() {
        return trasncript;
    }

    public void setTrasncript(File trasncript) {
        this.trasncript = trasncript;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Educationalbackground> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Educationalbackground> degrees) {
        this.degrees = degrees;
    }

    public List<AuditStatus> getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(List<AuditStatus> auditstatus) {
        this.auditstatus = auditstatus;
    }

}
