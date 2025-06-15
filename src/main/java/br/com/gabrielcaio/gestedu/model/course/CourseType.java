package br.com.gabrielcaio.gestedu.model.course;

public enum CourseType {
    BASIC_COMMON("Básico Comum"),
    BASIC_INTERNSHIP("Básico Específico de Estágio"),
    BASIC_TCC("Básico Específico de TCC"),
    BASIC_COURSE("Básico Específico do Curso"),
    COMPLEMENTARY_AACC("Complementar (AACC)"),
    COMPLEMENTARY_ELECTIVE("Complementar (Eletivos e Livres)"),
    FREE("Livres");

    private final String description;

    CourseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}