package com.aula.livraria.rest.address;


import com.aula.livraria.model.Address.AddressDTO;
import com.aula.livraria.rest.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = AddressController._PATH)
public class AddressController {

    public static final String _PATH = "/addresses";

    private final AddressService addressService;


    @Autowired
    AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }


    @GetMapping(value = "/{cep}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable(value = "cep") String cep) {
        return ResponseEntity.ok(this.addressService.getAddress(cep));
    }


}
