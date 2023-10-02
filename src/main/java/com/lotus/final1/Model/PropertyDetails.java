package com.lotus.final1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_propertydetails")
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertydetailid")
    private int PropertyDetailID;
    @Column(name = "propertydetailcode")
    private String PropertyDetailCode;
    @Column(name = "propertydetaildetail")
    private String PropertyDetailDetail;
    @OneToMany(mappedBy = "propertyDetails")
    @JsonIgnoreProperties(value = "propertyDetails")
    Set<ProductDetailPropertyDetails> productDetailPropertyDetails;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "propertyid")
    @JsonIgnoreProperties(value = "propertyDetails")
    Properties properties;

    public PropertyDetails() {
    }

    public PropertyDetails(String propertyDetailCode, String propertyDetailDetail, Properties properties) {
        PropertyDetailCode = propertyDetailCode;
        PropertyDetailDetail = propertyDetailDetail;
        this.properties = properties;
    }

    public int getPropertyDetailID() {
        return PropertyDetailID;
    }

    public void setPropertyDetailID(int propertyDetailID) {
        PropertyDetailID = propertyDetailID;
    }

    public String getPropertyDetailCode() {
        return PropertyDetailCode;
    }

    public void setPropertyDetailCode(String propertyDetailCode) {
        PropertyDetailCode = propertyDetailCode;
    }

    public String getPropertyDetailDetail() {
        return PropertyDetailDetail;
    }

    public void setPropertyDetailDetail(String propertyDetailDetail) {
        PropertyDetailDetail = propertyDetailDetail;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
