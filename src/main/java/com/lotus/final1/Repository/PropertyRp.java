package com.lotus.final1.Repository;

import com.lotus.final1.Model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRp extends JpaRepository<Properties,Integer> {
    @Query(value = "SELECT propertyid FROM tb_property \n" +
            "where productid = :productid \n" +
            "order by propertysort desc\n" +
            "limit 1",nativeQuery = true)
    int getLastPropertyIdByProductID(@Param("productid")int productid);
}
