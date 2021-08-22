package com.aula.livraria.model.store;

import com.aula.livraria.core.AbstractEntity;
import com.aula.livraria.model.address.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store extends AbstractEntity {

    @Column(nullable = false, length = 75)
    private String name;

    @OneToOne
    private Address address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date openingDate;
}
