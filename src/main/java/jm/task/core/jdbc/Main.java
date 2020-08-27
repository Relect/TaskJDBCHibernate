package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connect = Util.getSQLConnection();
        UserDaoHibernateImpl usersService = new UserDaoHibernateImpl();
//        создание таблицы
        usersService.createUsersTable();
//        добавление 4 юзеров в таблицу
        List<User> users = new ArrayList<>();
        users.add(new User("Gennadiy", "Romanov", (byte) 36));
        users.add(new User("Sergei", "Pochuev", (byte) 35));
        users.add(new User("Dmitriy", "Leviy", (byte) 36));
        users.add(new User("Vasja", "kolbaskin", (byte) 33));
        for (User u : users) {
            usersService.saveUser(u.getName(), u.getLastName(), u.getAge());
            System.out.println("User с именем - " + u.getName() + " добавлен в базу данных");
        }
//        получение всех юзеров и вывод в консоль
        List<User> us = usersService.getAllUsers();
        for (User u : us) {
            System.out.println(u.toString());
        }
//        очистка таблицы
//        usersService.cleanUsersTable();
//        удаление таблицы
//        usersService.dropUsersTable();
    }
}
