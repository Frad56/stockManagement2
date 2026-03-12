package com.example.store.Controller.stockMangment;


import com.example.store.DTO.stockManagment.CharacteristicValueDTO;
import com.example.store.Model.StockMangement.CharacteristicValue;
import com.example.store.Service.stockManagment.interfaces.CharacteristicValueService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/characteristicValue")
public class CharacteristicValueController {

    private final CharacteristicValueService characteristicValueService;

    public CharacteristicValueController(CharacteristicValueService characteristicValueService) {
        this.characteristicValueService = characteristicValueService;
    }

    @PostMapping("/addCharacteristicValue")
    public ResponseEntity<CharacteristicValue> saveCharacteristicValue(CharacteristicValueDTO characteristicValue) {
        return ResponseEntity.ok(characteristicValueService.saveCharacteristicValue(characteristicValue));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CharacteristicValue> findCharacteristicValueById(Long characteristicValueId) {
        return ResponseEntity.ok(characteristicValueService.findCharacteristicValueById(characteristicValueId));
    }
    @GetMapping("/ListCharacteristicValues")
    public ResponseEntity<List<CharacteristicValue>> fetchCharacteristicValueList() {
        return ResponseEntity.ok(characteristicValueService.fetchCharacteristicValueList());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CharacteristicValue> updateCharacteristicValue(CharacteristicValueDTO characteristicValue, Long characteristicValueId) {
        return ResponseEntity.ok(characteristicValueService.updateCharacteristicValue(characteristicValue, characteristicValueId));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCharacteristicValueById(Long characteristicValueId) {
        characteristicValueService.deleteCharacteristicValueById(characteristicValueId);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
