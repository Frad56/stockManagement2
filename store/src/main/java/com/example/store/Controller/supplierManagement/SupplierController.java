package com.example.store.Controller.supplierManagement;


import com.example.store.DTO.supplierManagement.SupplierDTO;
import com.example.store.Model.supplierManagement.Supplier;
import com.example.store.Service.supplierManagement.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/supplier")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService){
        this.supplierService =supplierService;
    }

    @PostMapping("/suppliers")
    public ResponseEntity<Supplier> saveSupplier(@Valid @RequestBody SupplierDTO dto){
        Supplier supplier = supplierService.saveSupplier(dto);
        return ResponseEntity.ok(supplier);
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getListSuppliers(){
        return ResponseEntity.ok(supplierService.fetchSupplierList());
    }

    @GetMapping("suppliers/{id}")
    public ResponseEntity<Supplier> findSupplierById (@PathVariable("id") Long supplierId){
        Supplier supplier = supplierService.findSupplierById(supplierId);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("suppliers/{id}")
    public ResponseEntity<String> deleteSupplierById(@PathVariable("id") Long supplierId){
        supplierService.deleteSupplierByID(supplierId);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
