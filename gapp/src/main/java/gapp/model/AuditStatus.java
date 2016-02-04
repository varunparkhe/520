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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "auditstatus")
public class AuditStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    /* Record the time when the change was made TIMESTAMP */
    Date time;

    @Basic
    @Column(name = "comments")
    String comments;

    @ManyToOne
    ApplicationStatus applicationstatus;

    @ManyToOne
    Applications applicant;

    public AuditStatus() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ApplicationStatus getApplicationstatus() {
        return applicationstatus;
    }

    public void setApplicationstatus(ApplicationStatus applicationstatus) {
        this.applicationstatus = applicationstatus;
    }

    public Applications getApplicant() {
        return applicant;
    }

    public void setApplicant(Applications applicant) {
        this.applicant = applicant;
    }



}
