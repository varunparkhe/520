package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    UserDao userDao;


    /*
     * student1 has submitted one application.
     * 
     * Using the UserDao to get the object of the student1 username and than looking in the
     * application list if it contains an application , Hence return 1 true.
     */
    @Test
    public void getApplication() {

        assert userDao.getUsername("student1@localhost.localdomanin").getApplication().size() == 1;


    }

}
