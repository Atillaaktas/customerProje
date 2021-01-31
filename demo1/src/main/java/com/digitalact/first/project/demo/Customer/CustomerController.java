package com.digitalact.first.project.demo.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
   private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<List<Customer>>getAll(){

        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{customerid}")
    public ResponseEntity<Customer> getById(@PathVariable Long customerid){

        return ResponseEntity.ok(customerService.getCustomerById(customerid));

    }


    @PostMapping
    public  ResponseEntity<Customer> create(@RequestBody Customer customer){

    Customer newCustomer = customerService.create(customer);

    return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    @PutMapping("/{customerid}")
    public  ResponseEntity<Customer> update(@RequestBody Customer newCustomer,@PathVariable Long customerid){

        Customer updatedCustomer = customerService.updateCustomerById(newCustomer,customerid);

        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
    }


   @DeleteMapping("/{customerid}")
    public void delete(@PathVariable Long customerid){
        customerService.delete(customerid);

   }

}
