package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUsersTable() throws SQLException {
        UserDaoHibernateImpl usersTable = new UserDaoHibernateImpl();
        usersTable.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoHibernateImpl usersTable = new UserDaoHibernateImpl();
        usersTable.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException{
        UserDaoHibernateImpl usersTable = new UserDaoHibernateImpl();
        usersTable.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        UserDaoHibernateImpl usersTable = new UserDaoHibernateImpl();
        usersTable.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        UserDaoHibernateImpl usersTable = new UserDaoHibernateImpl();
        return usersTable.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        UserDaoHibernateImpl usersTable = new UserDaoHibernateImpl();
        usersTable.cleanUsersTable();
    }
}
