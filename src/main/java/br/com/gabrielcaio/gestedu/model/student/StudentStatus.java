package br.com.gabrielcaio.gestedu.model.student;

public enum StudentStatus {
    ACTIVE("Ativo"),
    INACTIVE("Inativo"),
    PENDING("Pendente"),
    GRADUATED("Formado"),
    DROPPED_OUT("Desistente");

    private final String description;

    StudentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
} 