package com.example.loginpage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserDtls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;
    private String email;
    private String employeeId;
    private String mobileNum;
    private String gender;
    private String password;
    private String role;
}
