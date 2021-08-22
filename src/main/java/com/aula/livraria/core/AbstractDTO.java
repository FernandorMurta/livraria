package com.aula.livraria.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class AbstractDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
}
