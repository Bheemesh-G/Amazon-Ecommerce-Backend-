package com.Amazon.Amazon.Repository;

import com.Amazon.Amazon.Entity.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderedRepository extends JpaRepository<Ordered,Integer> {
}
