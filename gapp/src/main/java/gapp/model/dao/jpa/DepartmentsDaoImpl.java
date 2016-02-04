package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Departments;
import gapp.model.Programs;
import gapp.model.User;
import gapp.model.dao.DepartmentsDao;

/*
 * Department Implementations
 */

@Repository
public class DepartmentsDaoImpl implements DepartmentsDao {



    @PersistenceContext
    private EntityManager entityManager;

    /*
     * return the id of the department.
     */
    @Override
    public Departments getDepartments(Integer id) {

        return entityManager.find(Departments.class, id);
    }

    /*
     * return saved list of Departments.
     */
    @Override
    public List<Departments> getDepartment() {
        return entityManager.createQuery("from Departments order by id", Departments.class)
                .getResultList();
    }

    /*
     * return the saved object of Departments.
     */
    @Override
    public Departments saveDepartments(Departments departments) {
        return entityManager.merge(departments);
    }



}
