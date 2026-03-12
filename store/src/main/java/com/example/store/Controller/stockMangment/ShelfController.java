package com.example.store.Controller.stockMangment;


import com.example.store.DTO.stockManagment.ShelfDTO;
import com.example.store.Model.StockMangement.Shelf;
import com.example.store.Service.stockManagment.interfaces.ShelfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shelf")
public class ShelfController {
    private final ShelfService shelfService;

    public ShelfController(ShelfService shelfService) {
        this.shelfService = shelfService;
    }
    @PostMapping("/addShelf")
    public ResponseEntity<Shelf> saveShelf(ShelfDTO shelfDTO) {
        return ResponseEntity.ok(shelfService.saveShelf(shelfDTO));
    }
    @GetMapping("/ListShelves")
    public ResponseEntity<List<Shelf>> fetchShelfList() {
        return ResponseEntity.ok(shelfService.fetchShelfList());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Shelf> findShelfById(Long shelfId) {
        return ResponseEntity.ok(shelfService.findShelfById(shelfId));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteShelfById(Long shelfId) {
        shelfService.deleteShelfById(shelfId);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Shelf> updateShelf(ShelfDTO shelfDTO, Long shelfId) {
        return ResponseEntity.ok(shelfService.updateShelf(shelfDTO, shelfId));
    }


}
