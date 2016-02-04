package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Applications;
import gapp.model.User;
import gapp.model.dao.ApplicationsDao;



/*
 * Methods created to complete all the Model Design issues and address everything.
 */
@Repository
public class ApplicationsDaoImpl implements ApplicationsDao {

    @PersistenceContext
    private EntityManager entityManager;


    /*
     * returns the id of the Applications.
     */
    @Override
    public Applications getApplications(Integer id) {
        return entityManager.find(Applications.class, id);
    }

    /*
     * return the list of Applications.
     */
    @Override
    public List<Applications> getApplications() {
        return entityManager.createQuery("from Applications order by id", Applications.class).getResultList();
    }
    
    /*
     * return the saved object of Applications.
     */
    @Override
    public Applications saveApplications(Applications applications) {
        return entityManager.merge(applications);
    }

    

}
