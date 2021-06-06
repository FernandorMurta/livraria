package com.aula.livraria.model.enums;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("MALE", "M", 1L),
    FEMALE("Female", "F", 2L);

    private final String label;

    private final String code;

    private final Long id;

    Gender(String label, String code, Long id) {
        this.label = label;
        this.code = code;
        this.id = id;
    }
}
