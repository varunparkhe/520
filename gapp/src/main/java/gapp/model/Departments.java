package gapp.model;

import java.io.Serializable;
import java.util.Date;
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
 * A department will offer a list of Programs. Also a department will have Additional Information.
 * 
 */

@Entity
@Table(name = "departments")
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Basic
    @Column(name = "departmentname")
    String departmentname;

     /* Fall , Spring , Winter    */
    @Basic
    @Column(name = "term")
    String term;

    /* Year of the Term */
    // Date year;
    String year;

    /* Department - Programs */
    @OneToMany(mappedBy = "departmentprog", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    List<Programs> programs;

    /* Department - Additional Information */
    @OneToMany(mappedBy = "departments", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    List<AdditionalInfo> additionalinfo;

    public Departments() {

        programs = new ArrayList<Programs>();

        additionalinfo = new ArrayList<AdditionalInfo>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Programs> getPrograms() {
        return programs;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPrograms(List<Programs> programs) {
        this.programs = programs;
    }

    public List<AdditionalInfo> getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(List<AdditionalInfo> additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

}
