package com.example.store.Controller.stockMangment;



import com.example.store.DTO.stockManagment.UnitDTO;
import com.example.store.Model.StockMangement.Unit;
import com.example.store.Service.stockManagment.interfaces.UnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/unit")
public class UnitController {
    private final UnitService unitService;
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }
    @PostMapping("/addUnit")
    public ResponseEntity<Unit> saveUnit(UnitDTO unitDTO) {
        return ResponseEntity.ok(unitService.saveUnit(unitDTO));
    }
    @GetMapping("/ListUnits")
    public ResponseEntity<List<Unit>> fetchUnitList() {
        return ResponseEntity.ok(unitService.fetchUnitList());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Unit> findUnitById(Long unitId) {
        return ResponseEntity.ok(unitService.findUnitById(unitId));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUnitById(Long unitId) {
        unitService.deleteUnitById(unitId);
        return ResponseEntity.ok("Deleted Successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Unit> updateUnit(UnitDTO unitDTO, Long unitId) {
        return ResponseEntity.ok(unitService.updateUnit(unitDTO, unitId));
    }
}
