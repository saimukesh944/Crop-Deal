package com.systemadmin.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="AdminList")
public class AdminDetails {

        @Id
        private int id;
        private int adminId;
        private String userName;
        private String emailId;
        private String password;

    public AdminDetails() {
    }

    public AdminDetails(int id, int adminId, String userName, String emailId, String password) {
        this.id = id;
        this.adminId = adminId;
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
