package org.codekage.pma.entities.enums;

import java.util.HashMap;

public enum Stage {
    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String displayName;

    Stage(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // method to return the dictionary of stages ordinal and display name
    public static HashMap<Integer, String> getStages() {
        var stages = new HashMap<Integer, String>();
        for (Stage stage : Stage.values()) {
            stages.put(stage.ordinal(), stage.getDisplayName());
        }
        return stages;
    }

    public static String getStage(int index) {
        for (Stage stage : Stage.values()) {
            if (stage.ordinal() == index) {
                return stage.getDisplayName();
            }
        }
        return null;
    }
}
