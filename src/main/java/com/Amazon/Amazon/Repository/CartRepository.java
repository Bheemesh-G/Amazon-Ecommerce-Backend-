package com.Amazon.Amazon.Repository;

import com.Amazon.Amazon.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
