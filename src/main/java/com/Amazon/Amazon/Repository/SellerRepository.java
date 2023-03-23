package com.Amazon.Amazon.Repository;

import com.Amazon.Amazon.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    Seller findBySellerPanNumber(String panNumber);
}
