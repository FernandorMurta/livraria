package com.aula.livraria.model.enums;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("MALE", "M", 0L),
    FEMALE("Female", "F", 1L);

    private final String label;

    private final String code;

    private final Long id;

    Gender(String label, String code, Long id) {
        this.label = label;
        this.code = code;
        this.id = id;
    }
}
