package gapp.model.dao;

import java.util.List;

import gapp.model.Programs;

/*
 * Programs has Department and Additional Information.
 * 
 */
public interface ProgramsDao {


    /*
     * get the id of the program.
     */
    Programs getProgramsid(Integer id);

    /*
     * get list of programs.
     */
    List<Programs> getPrograms();


    /*
     * save Programs
     */

    Programs savePrograms(Programs programs);


}
