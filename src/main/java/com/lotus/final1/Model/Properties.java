package com.lotus.final1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_property")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertyid")
    private int PropertyID;
    @Column(name = "propertyname")
    private String PropertyName;
    @Column(name = "propertysort")
    private int PropertySort;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productid")
    @JsonIgnoreProperties(value = "properties")
    Products products;
    @OneToMany(mappedBy = "properties")
    @JsonIgnoreProperties(value = "properties")
    Set<PropertyDetails> propertyDetails;

    public Properties() {
    }

    public Properties(String propertyName, int propertySort, Products products) {
        PropertyName = propertyName;
        PropertySort = propertySort;
        this.products = products;
    }

    public int getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(int propertyID) {
        PropertyID = propertyID;
    }

    public String getPropertyName() {
        return PropertyName;
    }

    public void setPropertyName(String propertyName) {
        PropertyName = propertyName;
    }

    public int getPropertySort() {
        return PropertySort;
    }

    public void setPropertySort(int propertySort) {
        PropertySort = propertySort;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
