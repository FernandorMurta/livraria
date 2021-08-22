package com.aula.livraria.model.address;

import com.aula.livraria.core.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO extends AbstractDTO {

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    public static Address toEntity(AddressDTO addressDTO) {
        Address address = new Address();

        address.setId(addressDTO.getId());
        address.setLogradouro(addressDTO.getLogradouro());
        address.setComplemento(addressDTO.getComplemento());
        address.setBairro(addressDTO.getBairro());
        address.setLocalidade(addressDTO.getLocalidade());
        address.setUf(addressDTO.getUf());

        return address;
    }

    public static AddressDTO fromEntity(Address address) {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId(address.getId());
        addressDTO.setLogradouro(address.getLogradouro());
        addressDTO.setComplemento(address.getComplemento());
        addressDTO.setBairro(address.getBairro());
        addressDTO.setLocalidade(address.getLocalidade());
        addressDTO.setUf(address.getUf());

        return addressDTO;
    }
}
