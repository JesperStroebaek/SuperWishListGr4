package com.example.superwishlistgr4.model;

public class Wish {
    private int wishID;
    private String titel;
    private String link;
    private String fulfillwish;
    private int userid;
    private int wishlistid;

    public Wish(int wishID, String titel, String link, String fulfillwish,
                int userid, int wishlistid) {

        this.wishID = wishID;
        this.titel = titel;
        this.link = link;
        this.fulfillwish = fulfillwish;
        this.userid = userid;
        this.wishlistid = wishlistid;
    }

    public int getWishID() {
        return wishID;
    }

    public void setWishID(int wishID) {
        this.wishID = wishID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFulfillwish() {
        return fulfillwish;
    }

    public void setFulfillwish(String fulfillwish) {
        this.fulfillwish = fulfillwish;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getWishlistid() {
        return wishlistid;
    }

    public void setWishlistid(int wishlistid) {
        this.wishlistid = wishlistid;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "wishID=" + wishID +
                ", titel='" + titel + '\'' +
                ", link='" + link + '\'' +
                ", fulfillwish='" + fulfillwish + '\'' +
                ", userid=" + userid +
                ", wishlistid=" + wishlistid +
                '}';
    }
}
