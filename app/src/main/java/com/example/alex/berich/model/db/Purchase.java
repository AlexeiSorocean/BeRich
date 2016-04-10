package com.example.alex.berich.model.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "PURCHASE".
 */
public class Purchase {

    private Long id;
    private long productId;
    private long userId;
    /** Not-null value. */
    private java.util.Date date;

    public Purchase() {
    }

    public Purchase(Long id) {
        this.id = id;
    }

    public Purchase(Long id, long productId, long userId, java.util.Date date) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    /** Not-null value. */
    public java.util.Date getDate() {
        return date;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setDate(java.util.Date date) {
        this.date = date;
    }

}
