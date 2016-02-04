package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Programs;
import gapp.model.dao.ProgramsDao;

/*
 * 
 * Methods
 */
@Repository
public class ProgramsDaoImpl implements ProgramsDao {

    @PersistenceContext
    private EntityManager entitymnager;

    /*
     * return all the Programs by id.
     */
    @Override
    public Programs getProgramsid(Integer id) {
        return entitymnager.find(Programs.class, id);
    }

    /*
     * return list of Programs.
     */
    @Override
    public List<Programs> getPrograms() {

        return entitymnager.createQuery("from Programs order by id", Programs.class)
                .getResultList();
    }

    /*
     * return saved Programs
     */

    @Override
    public Programs savePrograms(Programs programs) {
        return entitymnager.merge(programs);
    }



}
