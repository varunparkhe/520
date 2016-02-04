package gapp.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/*
 * The Main User class.
 * 
 * The User consist of Role or the type of User is distinguished by its roles.
 * 
 * User also references the Applications and can handle them.
 * 
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /* Unique user id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    /* First Name of User */
    @Basic
    private String firstname;


    /* Last Name of User */
    @Basic
    private String lastname;


    /* Email taken as username for login purpose */
    @Basic
    @Column(name = "username", nullable = false, unique = true)
    private String username;


    /* password filed for user */
    @Basic
    @Column(name = "password", nullable = false)
    private String password;


    @Basic
    @Column(name = "cin")
    private String cin;


    /* the phone no of the user */
    @Basic
    @Column(name = "phoneno")
    private String phoneno;


    /* gender type of user */
    @Basic
    @Column(name = "gender")
    private String gender;


    /* date of birth of user */
    @Basic
    @Column(name = "dob")
    private String dob;


    /* country the user belongs to */
    @Basic
    @Column(name = "citizenship")
    private String citizenship;


    @Basic
    private boolean enabled;



    /*
     * Many to Many mapping taking into considerations all possibilities and outcomes.
     */
    @ManyToMany(mappedBy = "user")
    List<Role> role;


    /* List of Application One To Many */
    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    List<Applications> application;



    /* Default Constructor & Methods */
    public User() {

        enabled = true;

        role = new ArrayList<Role>();

        application = new ArrayList<Applications>();
    }



    /*
     * Compare and return the User Type
     */
    public boolean isStaff() {
        return role.contains("staff");
    }

    public boolean isStudent() {
        return role.contains("student");
    }

    public boolean isAdmin() {
        return role.contains("admin");
    }


    /*
     * The Getter's & Setter's
     */


    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public List<Applications> getApplication() {
        return application;
    }

    public void setApplication(List<Applications> application) {
        this.application = application;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
