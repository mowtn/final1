package com.lotus.final1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_productdetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailid")
    private int ProductDetailID;
    @Column(name = "productdetailname")
    private String ProductDetailName;
    @Column(name ="quantity")
    private int Quantity;
    @Column(name = "price")
    private float Price;
    @Column(name = "shellprice")
    private float ShellPrice;
    @Column(name = "parentid")
    private int ParentId;
    @OneToMany(mappedBy = "productDetails")
    @JsonIgnoreProperties(value = "productDetails")
    Set<ProductDetailPropertyDetails> productDetailPropertyDetails;



    public ProductDetails() {
    }

    public ProductDetails(String productDetailName, int quantity, float price, float shellPrice, int parentId) {
        ProductDetailName = productDetailName;
        Quantity = quantity;
        Price = price;
        ShellPrice = shellPrice;
        ParentId = parentId;
    }

    public int getProductDetailID() {
        return ProductDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        ProductDetailID = productDetailID;
    }

    public String getProductDetailName() {
        return ProductDetailName;
    }

    public void setProductDetailName(String productDetailName) {
        ProductDetailName = productDetailName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public float getShellPrice() {
        return ShellPrice;
    }

    public void setShellPrice(float shellPrice) {
        ShellPrice = shellPrice;
    }

    public int getParentId() {
        return ParentId;
    }

    public void setParentId(int parentId) {
        ParentId = parentId;
    }

}
