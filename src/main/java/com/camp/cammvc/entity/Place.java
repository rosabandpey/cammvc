package com.camp.cammvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Place  implements Serializable {

    private static final long serialVersionUID = -6955836358739196271L;

    private long id;

    private String placeName;

    private String parentName;

    public Place() {
    }

    public Place(long id, String placeName, String parentName) {
        this.id = id;
        this.placeName = placeName;
        this.parentName = parentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
