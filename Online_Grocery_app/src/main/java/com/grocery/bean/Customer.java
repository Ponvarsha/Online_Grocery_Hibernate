package com.grocery.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Customer {

    @Id
    private String customerID;
    private String fullName;
    private String mobile;
    private String address;
    private String preferredSlot;



    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPreferredSlot() {
        return preferredSlot;
    }

    public void setPreferredSlot(String preferredSlot) {
        this.preferredSlot = preferredSlot;
    }
}
