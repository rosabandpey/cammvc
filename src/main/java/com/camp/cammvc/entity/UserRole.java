package com.camp.cammvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.io.Serializable;



public class UserRole implements Serializable {

    private static final long serialVersionUID = -121838495708416186L;


    private long userRoleId;


    private Role role;


    private AppUser appuser;

    public UserRole() {
    }


    public UserRole(AppUser appuser, Role role) {

        this.appuser = appuser;
        this.role = role;
    }

    public UserRole(long userRoleId, Role role, AppUser appuser) {
        this.userRoleId = userRoleId;
        this.role = role;
        this.appuser = appuser;
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AppUser getAppuser() {
        return appuser;
    }

    public void setAppuser(AppUser appuser) {
        this.appuser = appuser;
    }
}
