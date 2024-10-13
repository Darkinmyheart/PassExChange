package vn.Pass.Exchange.Enum;

public enum Role {
    ADMIN("Administrator role"),
    USER("Standard user role");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
