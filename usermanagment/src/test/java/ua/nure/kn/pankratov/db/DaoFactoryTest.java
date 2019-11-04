package test.java.ua.nure.kn.pankratov.db;

import junit.framework.TestCase;
import main.java.ua.nure.kn.pankratov.db.Dao;
import main.java.ua.nure.kn.pankratov.db.DaoFactory;

public class DaoFactoryTest extends TestCase {

    public void testUserDao() {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            assertNotNull("Dao factory is null", daoFactory);
            Dao dao = daoFactory.getDao();
            assertNotNull("UserDao is null", dao);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }
}