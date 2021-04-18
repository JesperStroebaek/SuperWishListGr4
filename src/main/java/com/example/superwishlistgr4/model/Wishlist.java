package com.example.superwishlistgr4.model;

import java.sql.Date;

public class Wishlist {
    private int wishlistid;
    private String wishtlistname;
    private Date enddate;
    private int userid;

    public Wishlist(String wishtlistname, Date enddate) {
        this.wishlistid = wishlistid;
        this.wishtlistname = wishtlistname;
        this.enddate = enddate;
        this.userid = userid;
    }

    public int getWishlistid() {
        return wishlistid;
    }

    public void setWishlistid(int wishlistid) {
        this.wishlistid = wishlistid;
    }

    public String getWishtlistname() {
        return wishtlistname;
    }

    public void setWishtlistname(String wishtlistname) {
        this.wishtlistname = wishtlistname;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
