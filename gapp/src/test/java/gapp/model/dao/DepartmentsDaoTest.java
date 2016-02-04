package gapp.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import gapp.model.Departments;

@Test(groups = "DepartmentsDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DepartmentsDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    DepartmentsDao departmentdao;

    /*
     * There are two departments in the system.
     * 
     * Test Case written to get the size of Department from the list.
     */
    @Test
    public void getDepartment() {
        assert departmentdao.getDepartment().size() == 2;
    }



    /*
     * For the Accounting Department, there is one application for Fall 2016.
     * 
     * Here we are writing one query to get all the List of Departments and using the List object we
     * are iterating to get the specified result.
     * 
     */
    @Test
    public void getDepartmentName() {

        List<Departments> departments = departmentdao.getDepartment();

        int iterator = 0;

        for (Departments dept : departments) {
            if ((dept.getDepartmentname().equals("Accounting Department"))
                    && (dept.getTerm().equals("Fall")) && (dept.getYear().equals("2016"))) {
                iterator++;
            }
        }

        assert iterator == 1;

    }

}
