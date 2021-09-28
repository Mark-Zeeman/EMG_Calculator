package com.emguidance.assessment.markzeeman.emgcalculator.model;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */

import java.util.Objects;

public class Profile{
    public String about;
    public int address;
    public Object banner;
    public String dob;
    public String documents;
    public String examNumber;
    public String firstName;
    public int gender;
    public Boolean hasSiyavulaAccess;
    public int id;
    public String idNumber;
    public String imei;
    public String lastName;
    public Object mobileNr;
    public Object organization;
    public Object profilePic;
    public String serialNumber;
    public Object uniqueId;
    public int user;
    public String voucher;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public Object getBanner() {
        return banner;
    }

    public void setBanner(Object banner) {
        this.banner = banner;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Boolean getHasSiyavulaAccess() {
        return hasSiyavulaAccess;
    }

    public void setHasSiyavulaAccess(Boolean hasSiyavulaAccess) {
        this.hasSiyavulaAccess = hasSiyavulaAccess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getMobileNr() {
        return mobileNr;
    }

    public void setMobileNr(Object mobileNr) {
        this.mobileNr = mobileNr;
    }

    public Object getOrganization() {
        return organization;
    }

    public void setOrganization(Object organization) {
        this.organization = organization;
    }

    public Object getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Object profilePic) {
        this.profilePic = profilePic;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Object getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Object uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return getAddress() == profile.getAddress() &&
                getGender() == profile.getGender() &&
                getId() == profile.getId() &&
                getUser() == profile.getUser() &&
                Objects.equals(getAbout(), profile.getAbout()) &&
                Objects.equals(getBanner(), profile.getBanner()) &&
                Objects.equals(getDob(), profile.getDob()) &&
                Objects.equals(getDocuments(), profile.getDocuments()) &&
                Objects.equals(getExamNumber(), profile.getExamNumber()) &&
                Objects.equals(getFirstName(), profile.getFirstName()) &&
                Objects.equals(getHasSiyavulaAccess(), profile.getHasSiyavulaAccess()) &&
                Objects.equals(getIdNumber(), profile.getIdNumber()) &&
                Objects.equals(getImei(), profile.getImei()) &&
                Objects.equals(getLastName(), profile.getLastName()) &&
                Objects.equals(getMobileNr(), profile.getMobileNr()) &&
                Objects.equals(getOrganization(), profile.getOrganization()) &&
                Objects.equals(getProfilePic(), profile.getProfilePic()) &&
                Objects.equals(getSerialNumber(), profile.getSerialNumber()) &&
                Objects.equals(getUniqueId(), profile.getUniqueId()) &&
                Objects.equals(getVoucher(), profile.getVoucher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAbout(), getAddress(), getBanner(), getDob(), getDocuments(), getExamNumber(), getFirstName(), getGender(), getHasSiyavulaAccess(), getId(), getIdNumber(), getImei(), getLastName(), getMobileNr(), getOrganization(), getProfilePic(), getSerialNumber(), getUniqueId(), getUser(), getVoucher());
    }

    @Override
    public String toString() {
        return "profile{" +
                "about='" + about + '\'' +
                ", address=" + address +
                ", banner=" + banner +
                ", dob='" + dob + '\'' +
                ", documents='" + documents + '\'' +
                ", examNumber='" + examNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender=" + gender +
                ", hasSiyavulaAccess=" + hasSiyavulaAccess +
                ", id=" + id +
                ", idNumber='" + idNumber + '\'' +
                ", imei='" + imei + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNr=" + mobileNr +
                ", organization=" + organization +
                ", profilePic=" + profilePic +
                ", serialNumber='" + serialNumber + '\'' +
                ", uniqueId=" + uniqueId +
                ", user=" + user +
                ", voucher='" + voucher + '\'' +
                '}';
    }
}



