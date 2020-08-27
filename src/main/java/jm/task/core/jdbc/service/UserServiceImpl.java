package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUsersTable() throws SQLException {
        UserDaoJDBCImpl usersTable = new UserDaoJDBCImpl();
        usersTable.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl usersTable = new UserDaoJDBCImpl();
        usersTable.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException{
        UserDaoJDBCImpl usersTable = new UserDaoJDBCImpl();
        usersTable.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        UserDaoJDBCImpl usersTable = new UserDaoJDBCImpl();
        usersTable.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        UserDaoJDBCImpl usersTable = new UserDaoJDBCImpl();
        return usersTable.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        UserDaoJDBCImpl usersTable = new UserDaoJDBCImpl();
        usersTable.cleanUsersTable();
    }
}
