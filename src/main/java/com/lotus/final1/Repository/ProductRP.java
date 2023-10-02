package com.lotus.final1.Repository;

import com.lotus.final1.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ProductRP extends JpaRepository<Products,Integer> {
}
