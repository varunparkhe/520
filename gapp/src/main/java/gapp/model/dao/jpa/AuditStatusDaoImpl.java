package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import gapp.model.AuditStatus;
import gapp.model.User;
import gapp.model.dao.AuditStatusDao;


/*
 * AuditStatus Implementations for getting all the information about the status of the User which
 * also contains ApplicationStatus.
 * 
 */

@Repository
public class AuditStatusDaoImpl implements AuditStatusDao {


    @PersistenceContext
    private EntityManager entityManager;


    /*
     * return the AuditStatus by id.
     */
    @Override
    public AuditStatus getAuditStatus(Integer id) {
        return entityManager.find(AuditStatus.class, id);
    }

    /*
     * return the comments.
     */
    @Override
    public AuditStatus getComments(String comments) {
        Query query = entityManager.createQuery("from AuditStatus where comments =:comments",
                AuditStatus.class);
        query.setParameter("comments", comments);
        return (AuditStatus) query.getSingleResult();
    }

    /*
     * return the List of AuditStaus.
     */
    @Override
    public List<AuditStatus> getAuditStatus() {
        return entityManager.createQuery("from AuditStatus order by id", AuditStatus.class)
                .getResultList();
    }


    /*
     * return the saved List.
     */
    @Override
    public AuditStatus saveAuditStatus(AuditStatus auditstatus) {
        return entityManager.merge(auditstatus);
    }



}
