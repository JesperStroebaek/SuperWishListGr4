package com.example.superwishlistgr4.dataAccess;

import com.example.superwishlistgr4.model.SQLexceptionhandler;
import com.example.superwishlistgr4.model.Wishlist;

import java.sql.*;

public class WishListMapper {
    //Den her kan måske skabe problemer_er der ikke sat en * forkert i string SQL.? Eller er id bare kommenteret ud?
    public void createWishlist(Wishlist wishlist) throws SQLexceptionhandler {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO Wishlist (/*wishlist_id,*/ wishlist_name, enddate, user_id) VALUES (/*?,*/ ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, wishlist.getWishlistid());
            ps.setString(1, wishlist.getWishtlistname());
            ps.setDate(2, wishlist.getEnddate());
            ps.setInt(3, wishlist.getUserid());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            wishlist.setWishlistid(id);
            System.out.println(SQL);
            System.out.println(ps);
        } catch (SQLException ex) {
            throw new SQLexceptionhandler(ex.getMessage());
        }
    }

    //gets wishlists from the data associated with the user_id
    public String getWishlist (Wishlist wishlist) throws SQLexceptionhandler {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT wishlist_name, enddate, wishlist_id FROM gift WHERE user_id =?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, wishlist.getUserid());
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {


            }

            System.out.println(SQL);
            System.out.println(ps);

            return wishlist.toString();

        } catch (SQLException ex) {
            throw new SQLexceptionhandler(ex.getMessage());
        }
    }
}
