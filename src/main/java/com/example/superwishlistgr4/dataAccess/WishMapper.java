package com.example.superwishlistgr4.dataAccess;

import com.example.superwishlistgr4.model.SQLexceptionhandler;
import com.example.superwishlistgr4.model.Wish;
import java.sql.*;

public class WishMapper
{









    public void createWish(Wish wish) throws SQLexceptionhandler {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO Wish (/*check table navne*/wishID, titel, link, fulfillwish, userID, wishlistid) VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, wish.getWishID());
            ps.setString(2, wish.getTitel());
            ps.setString(3, wish.getLink());
            ps.setString(4, wish.getFulfillwish());
            ps.setInt(5, wish.getUserid());
            ps.setInt(6, wish.getWishlistid());
            ps.executeUpdate();

            System.out.println("So far so good");

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            wish.setWishID(id);

            System.out.println("so far good");

            System.out.println(SQL);
            System.out.println(ps);
        } catch (SQLException ex) {
            throw new SQLexceptionhandler(ex.getMessage());
        }
    }

    //get wishes from data associated with the wishlists id
    public String getWishes (Wish wish) throws SQLexceptionhandler {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT wishlist_id, enddate, wishlist_id FROM wish WHERE wishlist_id =?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, wish.getWishlistid());
            ResultSet rs = ps.executeQuery();

            System.out.println("Select Statement worked");


            while (rs.next()) {


            }

            System.out.println("While succesfull");

            System.out.println(SQL);
            System.out.println(ps);

            return wish.toString();


        } catch (SQLException ex) {
        throw new SQLexceptionhandler(ex.getMessage());
        }
    }
}

