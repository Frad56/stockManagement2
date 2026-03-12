package com.example.store.Controller.stockMangment;


import com.example.store.DTO.stockManagment.MovementInStockDTO;
import com.example.store.Model.StockMangement.MovementInStock;
import com.example.store.Service.stockManagment.interfaces.MovementInStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movementInStock")
public class MovementInStockController {

    private final MovementInStockService movementInStockService;

    public MovementInStockController(MovementInStockService movementInStockService) {
        this.movementInStockService = movementInStockService;
    }

    @PostMapping("/addMovementInStock")
    public ResponseEntity<MovementInStock> saveMovementInStock(MovementInStockDTO movementInStockDTO) {
        return ResponseEntity.ok(movementInStockService.saveMovementInStock(movementInStockDTO));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MovementInStock> findMovementInStockById(Long movementInStockId) {
        return ResponseEntity.ok(movementInStockService.findMovementInStockById(movementInStockId));
    }


    @GetMapping("/ListMovementInStock")
    public ResponseEntity<List<MovementInStock>> fetchMovementInStockList() {
        return ResponseEntity.ok(movementInStockService.fetchMovementInStockList());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<MovementInStock> updateMovementInStock(MovementInStockDTO movementInStockDTO, Long movementInStockId)
    {        return ResponseEntity.ok(movementInStockService.updateMovementInStock(movementInStockDTO, movementInStockId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovementInStockById(Long movementInStockId) {
        movementInStockService.deleteMovementInStockById(movementInStockId);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
