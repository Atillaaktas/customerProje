package com.digitalact.first.project.demo.Order;
import com.digitalact.first.project.demo.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public ResponseEntity<List<Order>> getAll(){

        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{orderid}")
    public ResponseEntity<Order> getById(@PathVariable Long orderid){

        return ResponseEntity.ok(orderService.getOrderById(orderid));

    }


    @PostMapping
    public  ResponseEntity<Order> create(@RequestBody Order order){

        Order newOrder = orderService.create(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }


    @PutMapping("/{orderid}")
    public  ResponseEntity<Order> update(@RequestBody Order newOrder,@PathVariable Long orderid){

        Order updatedOrder = orderService.updateOrderById(newOrder,orderid);

        return ResponseEntity.status(HttpStatus.OK).body(updatedOrder);
    }


    @DeleteMapping("/{orderid}")
    public void delete(@PathVariable Long orderid){
        orderService.delete(orderid);

    }
    


}
