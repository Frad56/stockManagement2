package com.example.store.Service.stockManagment;

import com.example.store.Model.StockMangement.Place;

import java.util.List;

public interface PlaceService {

    Place savePlace(Place place);

    List<Place> fetchPlaceList();

    Place findPlaceById(Long place_id);
    void deletePlaceById(Long placeId);
}
