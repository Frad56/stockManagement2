package com.example.store.DTO.stockManagment;

import java.math.BigDecimal;
import java.util.List;


public class ProductDTO {
    private Long id;
    private String code;
    private String name;
    private BigDecimal unity_price;
    private Long category_id;
    private Long place_id;
    private Long stock_id;
    private List<Long> productIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getUnity_price() {
        return unity_price;
    }

    public void setUnityPrice(BigDecimal unity_price) {
        this.unity_price = unity_price;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getPlace_id() {
        return place_id;
    }

    public void setPlace_id(Long place_id) {
        this.place_id = place_id;
    }

    public Long getStock_id() {
        return stock_id;
    }

    public void setStock_id(Long stock_id) {
        this.stock_id = stock_id;
    }

    public void setUnity_price(BigDecimal unity_price) {
        this.unity_price = unity_price;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
