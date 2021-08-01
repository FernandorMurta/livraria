package com.aula.livraria.rest.address;

import com.aula.livraria.model.Address.AddressDTO;

public interface AddressService {


    AddressDTO getAddress(String cep);
}
