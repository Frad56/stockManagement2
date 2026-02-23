package com.example.store.Repository.StockManagment;

import com.example.store.Model.StockMangement.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Optional<Place> findPlaceByName(String name);
}
