package main.java.ua.nure.kn.pankratov.db;

import main.java.ua.nure.kn.pankratov.domain.User;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

public class HsqldbUserDao implements Dao<User> {

    public static final String INSERT_QUERY = "INSERT INTO users (firstname, lastname, dateofbirth) VALUES (?, ?, ?)";
    private ConnectionFactory connectionFactory;
    private static final String SELECT_ALL_QUERY = "SELECT * FROM users";



    public HsqldbUserDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public User create(User entity) throws DatabaseException {
        Connection connection = connectionFactory.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setDate(3, new Date(entity.getDateOfBirth().getTime()));
            int numberOfRow = statement.executeUpdate();
            if (numberOfRow != 1) {
                throw new DatabaseException("Number of inserted rows: " + numberOfRow);
            }
            CallableStatement callableStatement = connection.prepareCall("call IDENTITY ()");
            ResultSet key = callableStatement.executeQuery();
            if (key.next()) {
                entity.setId(new Long(key.getLong(1)));
            }
            key.close();
            callableStatement.close();
            statement.close();
            connection.close();
            return entity;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(User entity) throws DatabaseException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(User entity) throws DatabaseException {
        // TODO Auto-generated method stub

    }

    @Override
    public void find(long id) throws DatabaseException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<User> findAll() throws DatabaseException {
        try {
            Collection<User> result = new LinkedList<>();
            Connection connection = connectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setDateOfBirth(resultSet.getDate(4));
                result.add(user);
            }
            //close resources!!!

            return result;
        } catch(SQLException e) {
            throw new DatabaseException(e);
        }
    }





}
    /*@Override
    public User find(User entity) throws DatabaseUnitException {
        return null;
    }

    @Override
    public Collection<User> findAll(User entity) throws DatabaseUnitException {
        return null;
    }

}*/

