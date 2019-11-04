package test.java.ua.nure.kn.pankratov.db;

import main.java.ua.nure.kn.pankratov.db.ConnectionFactory;
import main.java.ua.nure.kn.pankratov.db.ConnectionFactoryImpl;
import main.java.ua.nure.kn.pankratov.db.DatabaseException;
import main.java.ua.nure.kn.pankratov.domain.User;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;

import main.java.ua.nure.kn.pankratov.db.HsqldbUserDao;
import org.dbunit.dataset.xml.XmlDataSet;

import java.util.Calendar;
import java.util.Collection;

public class HsqldbUserDaoTest extends DatabaseTestCase {

    private ConnectionFactory connectionFactory;
    private static final int DAY_OF_BIRTH = 1;
    private static final int MONTH = 1;
    private static final int YEAR = 2010;
    private HsqldbUserDao dao;
    private static final String LAST_NAME = "Gates";
    private static final String FIRST_NAME = "Bill";

    public void testCreate() throws DatabaseException {
        User user = new User();
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR,MONTH, DAY_OF_BIRTH);
        user.setDateOfBirth(calendar.getTime());
        assertNull(user.getId());
        User userToCheck = dao.create(user);
        assertNotNull(userToCheck);
        assertNotNull(userToCheck.getId());
        assertEquals(FIRST_NAME,userToCheck.getFirstName());
        assertEquals(LAST_NAME,userToCheck.getLastName());
        assertEquals(calendar.getTime(), userToCheck.getDateOfBirth());
    }

    public void testFindAll() throws DatabaseException {
        Collection<User> items = dao.findAll();
        assertNotNull(items);
        assertEquals(2, items.size());
    }

    protected void setUp() throws Exception {
        super.setUp();
        dao = new HsqldbUserDao(connectionFactory);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        connectionFactory = new ConnectionFactoryImpl();
        return new DatabaseConnection(connectionFactory.getConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
        return dataSet;
    }

}