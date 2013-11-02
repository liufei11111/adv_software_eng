package enums;

public enum AccountTypeEnum {

    ADMIN("ADMIN"),
    PLAYER("PLAYER");

    private final String accountType;

    AccountTypeEnum(String accountType) {
        this.accountType = accountType;
    }

    public final String getAccountType() {
        return accountType;
    }

    public static AccountTypeEnum forValue(final String accountType) {
        for (AccountTypeEnum e : values()) {
            if (e.accountType.equalsIgnoreCase(accountType)) {
                return e;
            }
        }
        throw new IllegalArgumentException("No Enum Found. Invalid Account Type " + accountType);
    }

    public final String getValue() {
        return accountType;
    }

    public final String toString() {
        return accountType;
    }

}
