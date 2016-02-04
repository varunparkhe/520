package gapp.model.dao;

import java.util.List;

import gapp.model.Departments;
import gapp.model.User;

/*
 * 
 * Interface for Departments.
 */

public interface DepartmentsDao {
    
    
    /*
     * get Department by id.
     */
    Departments getDepartments(Integer id);

    
    
    /*
     * get all Department object in a list.
     */
    List<Departments> getDepartment();
    
    
    /*
     * save the Department object.
     */
    Departments saveDepartments(Departments departments);
    
    
}
