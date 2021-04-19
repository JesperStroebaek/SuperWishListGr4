package com.example.superwishlistgr4.data;

import com.example.superwishlistgr4.model.User;
import com.example.superwishlistgr4.model.SQLexceptionhandler;
import java.sql.*;


public class UserMapper {
    public void createUser(User user) throws SQLexceptionhandler {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO Users (username, passwordwish) VALUES (?, ?)";

            System.out.println("så godt");

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            System.out.println("SAT TIL SQL");

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);

            System.out.println("ID er sat");

        } catch (SQLException ex) {
            throw new SQLexceptionhandler(ex.getMessage());
        }
    }

    public User login(String username, String password) throws SQLexceptionhandler {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT id FROM users "
                    + "WHERE username=? AND passwordwish=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                User user = new User(username, password, id);
                user.setId(id);
                return user;
            } else {
                throw new SQLexceptionhandler("Could not validate user");
            }
        } catch (SQLException ex) {
            throw new SQLexceptionhandler(ex.getMessage());
        }
    }
}


