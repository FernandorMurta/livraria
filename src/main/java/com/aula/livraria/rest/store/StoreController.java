package com.aula.livraria.rest.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = StoreController._PATH)
public class StoreController {

    public static final String _PATH = "/stores";

    private final StoreService storeService;

    @Autowired
    StoreController(StoreServiceImpl storeService) {
        this.storeService = storeService;
    }


}
