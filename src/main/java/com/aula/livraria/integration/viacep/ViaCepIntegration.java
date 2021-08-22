package com.aula.livraria.integration.viacep;

import com.aula.livraria.model.address.AddressDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCepIntegration {

    @Value(value = "${via-cep.domain}")
    private String url;


    public AddressDTO getAddressByCep(String cep) {

        String urlFormatted = this.formatUrl(cep);
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForEntity(urlFormatted, AddressDTO.class).getBody();
    }


    private String formatUrl(String cep){
        return this.url.replace("{cep}", cep);
    }
}
