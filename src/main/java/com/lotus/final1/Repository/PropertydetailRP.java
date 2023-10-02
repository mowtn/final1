package com.lotus.final1.Repository;

import com.lotus.final1.Model.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertydetailRP extends JpaRepository<PropertyDetails,Integer> {
}
