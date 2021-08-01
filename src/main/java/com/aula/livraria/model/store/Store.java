package com.aula.livraria.model.store;

import com.aula.livraria.core.AbstractEntity;
import com.aula.livraria.model.Address.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store extends AbstractEntity {

    private String name;

    @OneToOne
    private Address address;
}
