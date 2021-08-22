package com.aula.livraria.rest.store;

import com.aula.livraria.model.store.StoreDTO;

public interface StoreService {

    StoreDTO createStore(StoreDTO store);

    StoreDTO findStoreById(Long id) throws Exception;
}
