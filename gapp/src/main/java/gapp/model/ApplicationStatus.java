package gapp.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;


/*
 * 
 * Here we will have all the System default Status of the application is assigned to and later on
 * updated. 1. New , 2. Pending Review , 3. Denied , 4. Recommend Admit , 5. Recommend Admit w/
 * Condition .
 * 
 */

@Entity
@Table(name = "applicationstatus")
public class ApplicationStatus implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Basic
    @Column(name = "status")
    String status;

    @OneToMany(mappedBy = "applicationstatus", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    List<AuditStatus> auditstatus;

    public ApplicationStatus() {

        auditstatus = new ArrayList<AuditStatus>();
    }



    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public List<AuditStatus> getAuditstatus() {
        return auditstatus;
    }


    public void setAuditstatus(List<AuditStatus> auditstatus) {
        this.auditstatus = auditstatus;
    }


}
