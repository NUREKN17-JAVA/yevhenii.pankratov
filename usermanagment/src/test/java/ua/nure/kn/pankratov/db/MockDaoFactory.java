package test.java.ua.nure.kn.pankratov.db;


import com.mockobjects.dynamic.Mock;
import main.java.ua.nure.kn.pankratov.db.Dao;
import main.java.ua.nure.kn.pankratov.db.DaoFactory;

public class MockDaoFactory extends DaoFactory {

    private Mock mockUserDao;

    public MockDaoFactory() {
        mockUserDao = new Mock(Dao.class);
    }

    public Mock getMockUserDao() {
        return mockUserDao;
    }

    public Dao getUserDao() {
        return (Dao) mockUserDao.proxy();
    }

}