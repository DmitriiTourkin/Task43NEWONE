package com.example.HELLO;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
//@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;


    private String role;

    static private long cur_id = 0;
    public Users(){
        this.id = cur_id;
        cur_id++;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String roles) {
        this.role = roles;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Id
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "\n" +
                "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + role +
                '}' +
                "\n";
    }
}