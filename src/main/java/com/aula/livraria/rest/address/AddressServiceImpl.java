package com.aula.livraria.rest.address;

import com.aula.livraria.integration.viacep.ViaCepIntegration;
import com.aula.livraria.model.Address.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {


    private final ViaCepIntegration viaCepIntegration;

    @Autowired
    AddressServiceImpl(ViaCepIntegration viaCepIntegration){
        this.viaCepIntegration = viaCepIntegration;

    }


    @Override
    public AddressDTO getAddress(String cep) {
        return this.viaCepIntegration.getAddressByCep(cep);
    }
}
