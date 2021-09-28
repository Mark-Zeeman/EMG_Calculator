package com.emguidance.assessment.markzeeman.emgcalculator.model;

public class ProfileHolder {
    public Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "{" +
                "profile=" + profile +
                '}';
    }
}
