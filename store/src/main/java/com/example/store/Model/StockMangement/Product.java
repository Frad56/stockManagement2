package com.example.store.Model.StockMangement;


import com.example.store.Model.supplierManagement.ProductSupplier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @NotNull
    @Size(max=100)
    @Column(name ="code")
    private String code;

    @NotNull
    @Column(name ="name")
    private String name;

    @NotNull
    @Column(name ="unityPrice",precision = 10, scale = 2)
    private BigDecimal unityPrice;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name= "place_id")
    private  Place place;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private  Stock stock;


    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductSupplier> product_suppliers = new ArrayList<>();


    public Product(){}
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnityPrice() {
        return unityPrice;
    }

    public void setUnityPrice(BigDecimal unityPrice) {
        this.unityPrice = unityPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<ProductSupplier> getProduct_suppliers() {
        return product_suppliers;
    }

    public void setProduct_suppliers(List<ProductSupplier> product_suppliers) {
        this.product_suppliers = product_suppliers;
    }
}
