package com.lotus.final1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int ProductID;
    @Column(name = "productname")
    private String ProductName;
    @OneToMany(mappedBy = "products")
    @JsonIgnoreProperties(value = "products")
    Set<ProductDetailPropertyDetails> productDetailPropertyDetails;
    @OneToMany(mappedBy = "products")
    @JsonIgnoreProperties(value = "products")
    Set<Properties> properties;

    public Products() {
    }

    public Products(int productID, String productName) {
        ProductID = productID;
        ProductName = productName;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }


}
