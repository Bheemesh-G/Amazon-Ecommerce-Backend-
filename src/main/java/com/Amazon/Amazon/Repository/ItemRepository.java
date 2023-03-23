package com.Amazon.Amazon.Repository;

import com.Amazon.Amazon.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
