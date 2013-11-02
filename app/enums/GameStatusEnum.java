package enums;

public enum GameStatusEnum {

    CREATED("CREATED"),
    STARTED("STARTED"),
    END("END"),
    CANCELED("CANCELED");

    private final String status;

    GameStatusEnum(String status) {
        this.status = status;
    }

    public final String getStatus() {
        return status;
    }

    public static GameStatusEnum forValue(final String status) {
        for (GameStatusEnum e : values()) {
            if (e.status.equalsIgnoreCase(status)) {
                return e;
            }
        }
        throw new IllegalArgumentException("No Enum Found. Invalid Game Status: " + status);
    }

    public final String getValue() {
        return status;
    }

    public final String toString() {
        return status;
    }

}
