package com.example.DigitalFridgeAPI.models;

import org.springframework.web.bind.annotation.RequestBody;

//request DTO
public class RequestPojo {

   private Integer expiryDate;

   private Float quantity;

   private boolean isExpired;

    public RequestPojo(Integer expiryDate, Float quantity, boolean isExpired) {
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.isExpired = isExpired;
    }

    public RequestPojo() {
    }

    public Integer getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Integer expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public boolean getExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }
}
