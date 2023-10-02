package com.lotus.final1.Repository;

import com.lotus.final1.Model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductdetailRP extends JpaRepository<ProductDetails,Integer> {
}
