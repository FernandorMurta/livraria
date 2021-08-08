package com.aula.livraria.integration.dbjson;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Post {

    private Long id;

    private String title;

    private String author;
}
