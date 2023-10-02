package com.lotus.final1.Repository;

import com.lotus.final1.Model.ProductDetailPropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailPropertydetailRP extends JpaRepository<ProductDetailPropertyDetails,Integer> {
    @Query(value = "SELECT productdetailid " +
            "FROM tb_productdetailpropertydetail " +
            "WHERE productid = :productid AND propertydetailid IN (:propertydetailid) " +
            "GROUP BY productdetailid " +
            "HAVING COUNT(propertydetailid) = :count", nativeQuery = true)
    int GetProductDetailID(@Param("productid") int productid,
                           @Param("propertydetailid") List<Integer> propertydetailid,
                           @Param("count") int count);
}
