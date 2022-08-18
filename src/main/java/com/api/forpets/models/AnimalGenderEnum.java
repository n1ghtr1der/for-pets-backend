package com.api.forpets.models;

public enum AnimalGenderEnum {
    FEMALE("Female"),
    MALE("Male");

    private final String displayName;

    AnimalGenderEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
