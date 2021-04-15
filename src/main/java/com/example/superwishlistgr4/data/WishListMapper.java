package com.example.superwishlistgr4.data;

import com.example.superwishlistgr4.domain.SQLexceptionhandler;
import com.example.superwishlistgr4.domain.User;
import com.example.superwishlistgr4.domain.Wishlist;

import java.sql.*;

public class WishListMapper {
    //Den her kan måske skabe problemer
    public void createWishlist(Wishlist wishlist) throws SQLexceptionhandler {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO Wishlist (/*wishlist_id,*/ wishlist_name, enddate, user_id) VALUES (/*?,*/ ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1, wishlist.getWishlistid());
            ps.setString(1, wishlist.getWishtlistname());
            ps.setDate(2, wishlist.getEnddate());
            ps.setInt(3, wishlist.getUserid());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            wishlist.setWishlistid(id);
        } catch (SQLException ex) {
            throw new SQLexceptionhandler(ex.getMessage());
        }

    }
}
