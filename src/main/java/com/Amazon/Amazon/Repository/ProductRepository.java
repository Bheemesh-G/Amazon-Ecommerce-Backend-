package com.Amazon.Amazon.Repository;

import com.Amazon.Amazon.Entity.Product;
import com.Amazon.Amazon.Enum.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {



    List<Product> findByCatagory(Catagory catagory);
}
