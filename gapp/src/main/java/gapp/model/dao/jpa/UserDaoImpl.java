package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.User;
import gapp.model.dao.UserDao;

/*
 * Methods created for User utilities and also for verifying Login credentials.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    /*
     * return the user by id.
     */
    @Override
    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    /*
     * return the List of User details.
     */
    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User order by id", User.class).getResultList();
    }

    /*
     * Get the Username (non-Javadoc)
     * 
     * @see gapp.model.dao.UserDao#getUsername(java.lang.String)
     */
    @Override
    public User getUsername(String username) {
        Query query = entityManager.createQuery("from User where username =:username", User.class);
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }


    /*
     * get Password
     */
    @Override
    public User getPassword(String password) {
        Query q = entityManager.createQuery("from User where password =:password", User.class);
        q.setParameter("password", password);

        return (User) q.getSingleResult();
    }

    /*
     * save the User object
     */
    @Override
    public User saveUser(User user) {
        return entityManager.merge(user);
    }
}
