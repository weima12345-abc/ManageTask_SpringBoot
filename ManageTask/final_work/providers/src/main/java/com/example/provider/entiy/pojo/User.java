package com.example.provider.entiy.pojo;


public class User {
    private String id;
    private String name;
    private String address;
    private String email;
    private String roleName;
    public User() {
    }

    public User(String name, String address,String email,String roleName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email=email;
        this.roleName=roleName;
    }

    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role) {
        this.roleName = role;
    }
}
