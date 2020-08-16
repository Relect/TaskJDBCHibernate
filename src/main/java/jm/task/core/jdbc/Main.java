package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        Connection connect = Util.getSQLConnection();
        UserDaoJDBCImpl usersService = new UserDaoJDBCImpl();
//        usersService.createUsersTable();
//        User user1 = new User("Gennadiy", "Romanov", (byte) 36);
//        usersService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
//        usersService.dropUsersTable();
//        usersService.removeUserById(1);
          usersService.getAllUsers();
    }
}
