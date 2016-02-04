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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Here we take a list of all the Program a Department will offer. Department will offer multiple
 * programs. A Student will apply for one or multiple Programs.
 * 
 * Programs will contain Department and will contain nested Additional Fields.
 * 
 */

@Entity
@Table(name = "programs")
public class Programs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    /*
     * The name of the Program for which the Application is applied for.
     */
    @Basic
    @Column(name = "programname")
    String programname;

    /*
     * Program - Applications
     */
    @OneToMany(mappedBy = "prog", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    List<Applications> lstapplication;

    /*
     * Program - Department
     */
    @ManyToOne
    Departments departmentprog;

    public Programs() {

        lstapplication = new ArrayList<Applications>();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Applications> getLstapplication() {
        return lstapplication;
    }

    public void setLstapplication(List<Applications> lstapplication) {
        this.lstapplication = lstapplication;
    }

    public String getProgramname() {
        return programname;
    }

    public void setProgramname(String programname) {
        this.programname = programname;
    }

    public Departments getDepartmentprog() {
        return departmentprog;
    }

    public void setDepartmentprog(Departments departmentprog) {
        this.departmentprog = departmentprog;
    }

}
