package com.aula.livraria.model.enums;

public enum Gender {

    MALE("MALE", "M", 1L),
    FEMALE("Female", "F", 2L);

    private String label;

    private String code;

    private Long id;

    Gender(String label, String code, Long id) {
        this.label = label;
        this.code = code;
        this.id = id;
    }
}
