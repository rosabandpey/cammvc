package com.camp.cammvc.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Role implements Serializable {

    private static final long serialVersionUID  = -8109015272289072306L;


    private long id;

    private String roleName;


    private Set<UserRole> userRole=new HashSet<>();

    public Role() {
    }

    public Role(long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }



}
