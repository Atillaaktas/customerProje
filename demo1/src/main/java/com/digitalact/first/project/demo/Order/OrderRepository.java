package com.digitalact.first.project.demo.Order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByCustomerId(Long customerid);
    Optional<Order> findByCustomerId(Long id, Long customerid);


}
