package com.aula.livraria.model.store;


import com.aula.livraria.core.AbstractDTO;
import com.aula.livraria.model.address.AddressDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreDTO extends AbstractDTO {

    private String name;

    private AddressDTO address;

    private Date openingDate;

    public static Store toEntity(StoreDTO storeDTO) {
        Store store = new Store();

        store.setId(storeDTO.getId());
        store.setName(storeDTO.getName());
        store.setAddress(AddressDTO.toEntity(storeDTO.getAddress()));
        store.setOpeningDate(storeDTO.getOpeningDate());

        return store;
    }

    public static StoreDTO fromEntity(Store store) {
        StoreDTO storeDTO = new StoreDTO();

        storeDTO.setId(store.getId());
        storeDTO.setName(store.getName());
        storeDTO.setAddress(AddressDTO.fromEntity(store.getAddress()));
        storeDTO.setOpeningDate(store.getOpeningDate());

        return storeDTO;
    }
}
