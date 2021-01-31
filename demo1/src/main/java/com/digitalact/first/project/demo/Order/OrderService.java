package com.digitalact.first.project.demo.Order;

import com.digitalact.first.project.demo.Customer.Customer;
import com.digitalact.first.project.demo.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Order",id));
    }

    public Order create(Order order){
        return orderRepository.save(order);
    }

    public Order updateOrderById(Order newOrder,Long id){
        Order order = this.getOrderById(id);
        order.setDescription(newOrder.getDescription());
        order.setStatus(newOrder.getStatus());

        order.setCreatedDate(newOrder.getCreatedDate());
        return orderRepository.save(order);
    }

    public void delete (long id){

        Order order = this.getOrderById(id);
        orderRepository.delete(order);
    }


}
