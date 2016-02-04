package gapp.model.dao;

import java.util.List;

import gapp.model.User;

/*
 * User will have Roles.
 * 
 * UserDao has methods to get User by id , List of Users , Username , Password and to save the User
 * object.
 * 
 */

public interface UserDao {

    /*
     * get User by id.
     */
    User getUser(Integer id);

    /*
     * get all User object in a list.
     */
    List<User> getUsers();


    /*
     * Get Username for Login purpose.
     */
    User getUsername(String username);

    /*
     * Get Password for Login purpose.
     */
    User getPassword(String password);

    /*
     * Save the User object.
     * 
     */
    User saveUser(User user);


}
