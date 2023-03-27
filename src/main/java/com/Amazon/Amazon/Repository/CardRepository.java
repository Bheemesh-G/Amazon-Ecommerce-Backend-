package com.Amazon.Amazon.Repository;


import com.Amazon.Amazon.Entity.Card;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {




    @Transactional
    @Modifying
    @Query(value = "delete from card c where c.customer_customer_id = ?1",nativeQuery = true)
    void removeById(int customerId);
}
