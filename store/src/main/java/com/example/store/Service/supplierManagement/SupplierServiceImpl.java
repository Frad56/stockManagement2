package com.example.store.Service.supplierManagement;

import com.example.store.DTO.supplierManagement.SupplierDTO;
import com.example.store.Exception.ElementNotFoundException;
import com.example.store.Model.supplierManagement.Supplier;
import com.example.store.Repository.supplierManagement.SupplierRepository;
import com.example.store.Service.stockManagment.interfaces.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SupplierServiceImpl  implements SupplierService{

    private SupplierRepository supplierRepository;
    private ProductService productService;
    public SupplierServiceImpl(SupplierRepository supplierRepository,
                               ProductService productService){
        this.supplierRepository =supplierRepository;
        this.productService = productService;

    }

    @Override
    public Supplier saveSupplier(SupplierDTO supplierDTO){

        Supplier supplier = new Supplier();
        supplier.setCompany_name(supplierDTO.getCompanyName());
        supplier.setContact_name(supplierDTO.getContactName());
        supplier.setPhone_number(supplierDTO.getPhoneNumber());
        supplier.setFax(supplierDTO.getFax());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setCity(supplierDTO.getCity());
        supplier.setPostal_code(supplierDTO.getPostal_code());
        supplier.setCountry(supplierDTO.getCountry());


        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier findSupplierById(Long supplierId){
       return supplierRepository.findById(supplierId)
               .orElseThrow(() -> new ElementNotFoundException(supplierId));
    }

    @Override
    public List<Supplier> fetchSupplierList(){
        return supplierRepository.findAll();
    }

    @Override
    public void deleteSupplierByID(Long supplierId){
        if(!supplierRepository.existsById(supplierId)){
            throw  new ElementNotFoundException(supplierId);
        }
        supplierRepository.deleteById(supplierId);
    }
}

