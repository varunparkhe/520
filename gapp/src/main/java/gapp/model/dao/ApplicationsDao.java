package gapp.model.dao;


import java.util.List;

import gapp.model.Applications;
import gapp.model.User;

/*
 * ApplicationsDao will have Applications and all the details of everything.
 */

public interface ApplicationsDao {


    /*
     * get ApplicationsDao by id.
     */
    Applications getApplications(Integer id);


    /*
     * get all ApplicationsDao object in a list.
     */
    List<Applications> getApplications();


    /*
     * Save the Applications object.
     * 
     */
    Applications saveApplications(Applications applications);



}
