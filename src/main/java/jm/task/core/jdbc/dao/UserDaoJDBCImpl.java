package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl()  {
    }

    public void createUsersTable() throws SQLException{
        try {
            Connection conn = Util.getSQLConnection();
            String query = "Create table Users (id int(11) auto_increment primary key not null, " +
            "Name varchar(30) not null, lastName varchar(30) not null"
            + ", age tinyint not null);";
            Statement st = conn.createStatement();
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() throws SQLException {
        try {
            Connection conn = Util.getSQLConnection();
            String query = "Drop table Users;";
            Statement st = conn.createStatement();
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Connection conn = Util.getSQLConnection();
            String query = "Insert INTO Users values (id, ?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, lastName);
            pst.setInt(3, age);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            Connection conn = Util.getSQLConnection();
            String query = "DELETE FROM Users WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setLong(1, id);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> arrUsers = new ArrayList<User>();
        try {
            Connection conn = Util.getSQLConnection();
            String query = "SELECT * FROM Users";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User us = new User();
                us.setId(rs.getLong(1));
                us.setName(rs.getString(2));
                us.setLastName(rs.getString(3));
                us.setAge(rs.getByte(4));
                arrUsers.add(us);
            }
            System.out.println(arrUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrUsers;
    }

    public void cleanUsersTable() {
        try {
            Connection conn = Util.getSQLConnection();
            String query = "DELETE FROM Users";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
