package com.aula.livraria.rest.store;

import com.aula.livraria.model.store.Store;
import com.aula.livraria.model.store.StoreDTO;
import com.aula.livraria.repository.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    @Override
    public StoreDTO createStore(StoreDTO store) {

        Store entity = StoreDTO.toEntity(store);
        entity = this.storeRepository.save(entity);

        return StoreDTO.fromEntity(entity);
    }

    @Override
    public StoreDTO findStoreById(Long id) throws Exception {
        Store store = this.storeRepository.findById(id).orElseThrow(Exception::new);

        return StoreDTO.fromEntity(store);
    }

}
