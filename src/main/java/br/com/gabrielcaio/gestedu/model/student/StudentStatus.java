package br.com.gabrielcaio.gestedu.model.student;

public enum StudentStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    PENDING("PENDING"),
    GRADUATED("GRADUATED"),
    DROPPED_OUT("DROPPED_OUT");

    private final String description;

    StudentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
} 