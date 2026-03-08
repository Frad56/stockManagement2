package com.example.store.Service.stockManagment;

import com.example.store.DTO.stockManagment.ProductDTO;
import com.example.store.Model.StockMangement.Place;
import com.example.store.Model.StockMangement.Product;

import java.util.List;

public interface PlaceService {

   // ProductDTO convertToDTO(Product product);

    Place savePlace(Place place);

    List<Place> fetchPlaceList();

    Place findPlaceById(Long place_id);

    void deletePlaceById(Long placeId);
}
