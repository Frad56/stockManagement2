package com.example.store.Service.stockManagment.implementation;

import com.example.store.DTO.stockManagment.AisleDTO;
import com.example.store.Model.StockMangement.Aisle;
import com.example.store.Repository.StockManagment.AisleRepository;
import com.example.store.Service.stockManagment.interfaces.AisleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AisleServiceImpl implements AisleService {

    private final AisleRepository aisleRepository;

    @Autowired
        public AisleServiceImpl(AisleRepository aisleRepository){
            this.aisleRepository = aisleRepository;
        }


    private void mapDTOToAisle(AisleDTO aisleDTO, Aisle aisle) {
        aisle.setName(aisleDTO.getName());
    }
    @Override
    public Aisle saveAisle(AisleDTO aisleDTO) {
        Aisle aisle = new Aisle();
        mapDTOToAisle(aisleDTO, aisle);
        return aisleRepository.save(aisle);
    }

    @Override
    public List<Aisle> fetchAisleList() {
        return aisleRepository.findAll();
    }

    @Override
    public Aisle findAisleById(Long idAisle) {
        return aisleRepository.findById(idAisle).orElseThrow(()->
                new RuntimeException("Aisle not found with id: " + idAisle));
    }

    @Override
    public Aisle updateAisle(AisleDTO aisleDTO, Long aisleId) {
            Aisle aisle = findAisleById(aisleId);
        mapDTOToAisle(aisleDTO,aisle);
        return aisleRepository.save(aisle);
    }

    @Override
    public void deleteAisleById(Long aisleId) {
        if(!aisleRepository.existsById(aisleId)){
            throw new RuntimeException("Aisle not found with id: " + aisleId);
        }
        aisleRepository.deleteById(aisleId);
    }
}
