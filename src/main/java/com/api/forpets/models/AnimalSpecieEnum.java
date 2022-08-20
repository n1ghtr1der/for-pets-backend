package com.api.forpets.models.enums;

public enum AnimalSpecieEnum {
    BIRD("Bird"),
    FISH("Fish"),
    REPTILE("Reptile"),
    MAMMAL("Mammal");

    private final String displayName;

    AnimalSpecieEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
