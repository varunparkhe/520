package gapp.model.dao;

import java.util.List;

import gapp.model.AuditStatus;
import gapp.model.User;

/*
 * The AuditStatus has ApplicationStatus.
 */


public interface AuditStatusDao {


    /*
     * get AuditStatusDao by id.
     */
    AuditStatus getAuditStatus(Integer id);


    /*
     * get Comments as to why the Status is changed.
     */
    AuditStatus getComments(String comments);


    /*
     * get all AuditStatusDao object in a list.
     */
    List<AuditStatus> getAuditStatus();


    /*
     * Save the AuditStatus object.
     * 
     */
    AuditStatus saveAuditStatus(AuditStatus auditstatus);

}
