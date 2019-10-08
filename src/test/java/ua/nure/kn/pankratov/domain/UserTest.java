package test.java.ua.nure.kn.pankratov.domain;

import main.java.ua.nure.kn.pankratov.domain.User;

import junit.framework.TestCase;

import java.util.Calendar;

public class UserTest extends TestCase {

    // first person
    private static final int DAY_OF_BIRTH = 9;
    private static final int MONTH_OF_BIRTH = 11;
    private static final int YEAR_OF_BIRTH = 1999;
    private static final int ETHALON_AGE = 20;

    // second person
    private static final int MONTH_OF_BIRTH_1 = 3;
    private static final int ETALON_AGE_1 = 20;

    private User user;

    public void testGetFullName() {
        user.setFirstName("Ivan");
        user.setLastName("Petrol");
        assertEquals("Petrol Ivan", user.getFullName());
    }

    public void testGetAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DAY_OF_BIRTH);
        user.setDateOfBirth(calendar.getTime());
        assertEquals(ETHALON_AGE, user.getAge());
    }

    public void testGetAge1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH_1, DAY_OF_BIRTH);
        user.setDateOfBirth(calendar.getTime());
        assertEquals(ETALON_AGE_1, user.getAge());
    }

    public void testAgeHappyBirthdayTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, 9);
        user.setDateOfBirth(calendar.getTime());
        int realAge = user.getAge();
        assertEquals(ETHALON_AGE, realAge);
    }

    public void testArrivalAge() {
        int supposedAge = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        user.setDateOfBirth(calendar.getTime());
        int realAge = user.getAge();
        assertEquals(supposedAge, realAge);
    }

    public void testAgeHappyBirthdayToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        user.setDateOfBirth(calendar.getTime());
        int realAge = user.getAge();
        assertEquals(ETHALON_AGE, realAge);
    }

    protected void setUp() throws Exception {
        super.setUp();
        user = new User();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

}