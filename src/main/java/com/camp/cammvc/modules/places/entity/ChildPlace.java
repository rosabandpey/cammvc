package com.camp.cammvc.modules.places.entity;

import com.camp.cammvc.modules.users.entity.AppUser;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

public class ChildPlace  implements Serializable {

    private static final long serialVersionUID = -6955836358739196257L;

    private long id;

    private long mychildplace;

    private long userChildPlace;

    @NotBlank(message = "is required")
    private String childName;

    @NotBlank(message = "is required")
    private String childLocation;

    @NotBlank(message = "is required")
    private String childDetails;

    @NotBlank(message = "is required")
    private String childCountry;


    @NotBlank(message = "is required")
    private String childCity;

    @NotBlank(message = "is required")
    private String childAddress;

    private Integer childCellSignal;

    private Date childLastVisit;

    private Integer childCrowdness;

    private Integer childManNoise;

    private Integer childCleanness;

    private Integer childSafty;

    private Integer childWater;

    private Integer childElectronic;

    private Integer childShower;

    private Integer childTrash;

    private Integer childPicnicTable;

    private Integer childToilet;

    private Integer childWifi;

    private Integer childFirePits;

    private Integer childPetAllowed;

    private Integer childADAaccessible;


    public ChildPlace() {
    }

    public ChildPlace(long id,long mychildplace,long userChildPlace ,String childName, String childLocation, String childDetails, String childCountry, String childCity, String childAddress, int childCellSignal, Date childLastVisit, int childCrowdness, int childManNoise, int childCleanness, int childSafty, int childWater, int childElectronic, int childShower, int childTrash, int childPicnicTable, int childToilet, int childWifi, int childFirePits, int childPetAllowed, int childADAaccessible) {
        this.id = id;
        this.mychildplace = mychildplace;
        this.userChildPlace = userChildPlace;
        this.childName = childName;
        this.childLocation = childLocation;
        this.childDetails = childDetails;
        this.childCountry = childCountry;
        this.childCity = childCity;
        this.childAddress = childAddress;
        this.childCellSignal = childCellSignal;
        this.childLastVisit = childLastVisit;
        this.childCrowdness = childCrowdness;
        this.childManNoise = childManNoise;
        this.childCleanness = childCleanness;
        this.childSafty = childSafty;
        this.childWater = childWater;
        this.childElectronic = childElectronic;
        this.childShower = childShower;
        this.childTrash = childTrash;
        this.childPicnicTable = childPicnicTable;
        this.childToilet = childToilet;
        this.childWifi = childWifi;
        this.childFirePits = childFirePits;
        this.childPetAllowed = childPetAllowed;
        this.childADAaccessible = childADAaccessible;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMychildplace() {
        return mychildplace;
    }

    public void setMychildplace(long mychildplace) {
        this.mychildplace = mychildplace;
    }

    public long getUserChildPlace() {
        return userChildPlace;
    }

    public void setUserChildPlace(long userChildPlace) {
        this.userChildPlace = userChildPlace;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildLocation() {
        return childLocation;
    }

    public void setChildLocation(String childLocation) {
        this.childLocation = childLocation;
    }

    public String getChildDetails() {
        return childDetails;
    }

    public void setChildDetails(String childDetails) {
        this.childDetails = childDetails;
    }

    public String getChildCountry() {
        return childCountry;
    }

    public void setChildCountry(String childCountry) {
        this.childCountry = childCountry;
    }

    public String getChildCity() {
        return childCity;
    }

    public void setChildCity(String childCity) {
        this.childCity = childCity;
    }

    public String getChildAddress() {
        return childAddress;
    }

    public void setChildAddress(String childAddress) {
        this.childAddress = childAddress;
    }

    public Integer getChildCellSignal() {
        return childCellSignal;
    }

    public void setChildCellSignal(Integer childCellSignal) {
        this.childCellSignal = childCellSignal;
    }

    public Date getChildLastVisit() {
        return childLastVisit;
    }

    public void setChildLastVisit(Date childLastVisit) {
        this.childLastVisit = childLastVisit;
    }

    public Integer getChildCrowdness() {
        return childCrowdness;
    }

    public void setChildCrowdness(Integer childCrowdness) {
        this.childCrowdness = childCrowdness;
    }

    public Integer getChildManNoise() {
        return childManNoise;
    }

    public void setChildManNoise(Integer childManNoise) {
        this.childManNoise = childManNoise;
    }

    public Integer getChildCleanness() {
        return childCleanness;
    }

    public void setChildCleanness(Integer childCleanness) {
        this.childCleanness = childCleanness;
    }

    public Integer getChildSafty() {
        return childSafty;
    }

    public void setChildSafty(Integer childSafty) {
        this.childSafty = childSafty;
    }

    public Integer getChildWater() {
        return childWater;
    }

    public void setChildWater(Integer childWater) {
        this.childWater = childWater;
    }

    public Integer getChildElectronic() {
        return childElectronic;
    }

    public void setChildElectronic(Integer childElectronic) {
        this.childElectronic = childElectronic;
    }

    public Integer getChildShower() {
        return childShower;
    }

    public void setChildShower(Integer childShower) {
        this.childShower = childShower;
    }

    public Integer getChildTrash() {
        return childTrash;
    }

    public void setChildTrash(Integer childTrash) {
        this.childTrash = childTrash;
    }

    public Integer getChildPicnicTable() {
        return childPicnicTable;
    }

    public void setChildPicnicTable(Integer childPicnicTable) {
        this.childPicnicTable = childPicnicTable;
    }

    public Integer getChildToilet() {
        return childToilet;
    }

    public void setChildToilet(Integer childToilet) {
        this.childToilet = childToilet;
    }

    public Integer getChildWifi() {
        return childWifi;
    }

    public void setChildWifi(Integer childWifi) {
        this.childWifi = childWifi;
    }

    public Integer getChildFirePits() {
        return childFirePits;
    }

    public void setChildFirePits(Integer childFirePits) {
        this.childFirePits = childFirePits;
    }

    public Integer getChildPetAllowed() {
        return childPetAllowed;
    }

    public void setChildPetAllowed(Integer childPetAllowed) {
        this.childPetAllowed = childPetAllowed;
    }

    public Integer getChildADAaccessible() {
        return childADAaccessible;
    }

    public void setChildADAaccessible(Integer childADAaccessible) {
        this.childADAaccessible = childADAaccessible;
    }
}
