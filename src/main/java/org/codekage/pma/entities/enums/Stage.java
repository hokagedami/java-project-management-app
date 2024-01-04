package org.codekage.pma.entities.enums;

public enum Stage {
    NOT_STARTED("Not Started"),
    COMPLETED("Completed"),
    IN_PROGRESS("In Progress");

    private final String displayName;

    Stage(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
