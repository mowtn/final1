package com.lotus.final1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_productdetailpropertydetail")
public class ProductDetailPropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailpropertydetailid")
    private int ProductDetailPropertyDetailID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productdetailid")
    @JsonIgnoreProperties(value = "productDetailPropertyDetails")
    ProductDetails productDetails;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "propertydetailid")
    @JsonIgnoreProperties(value = "productDetailPropertyDetails")
    PropertyDetails propertyDetails;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productid")
    @JsonIgnoreProperties(value = "productDetailPropertyDetails")
    Products products;

    public ProductDetailPropertyDetails() {
    }

    public ProductDetailPropertyDetails(ProductDetails productDetails, PropertyDetails propertyDetails, Products products) {
        this.productDetails = productDetails;
        this.propertyDetails = propertyDetails;
        this.products = products;
    }

    public int getProductDetailPropertyDetailID() {
        return ProductDetailPropertyDetailID;
    }

    public void setProductDetailPropertyDetailID(int productDetailPropertyDetailID) {
        ProductDetailPropertyDetailID = productDetailPropertyDetailID;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(PropertyDetails propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
