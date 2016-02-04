package gapp.model;

import java.io.Serializable;
import java.util.ArrayList;
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
 * Here we have a list of all the additional information. Every Department will have their own
 * requirements.
 * 
 */

@Entity
@Table(name = "additionalfield")
public class AdditionalInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Basic
    @Column(name = "name")
    String name;

    /*
     * Here we can take ResourceType and resource (CSNS2) for handing which type of resource you
     * want i.e. File , Integer , String but it can be implement and made simple in the programming
     * interface , so not taken here to reduce the Model complexity for now.
     */
    @Basic
    @Column(name = "type")
    String type;

    Boolean required;

    /* AdditionalInformantion - Department */
    @ManyToOne
    Departments departments;

    public AdditionalInfo() {

        required = true;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

}
