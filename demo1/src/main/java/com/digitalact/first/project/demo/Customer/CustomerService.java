package com.digitalact.first.project.demo.Customer;
import com.digitalact.first.project.demo.Exception.ResourceNotFoundException;
import com.digitalact.first.project.demo.Order.Order;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List <Customer> getAll(){

        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){

        return customerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Customer",id));



    }

    public Customer create(Customer customer){

        return customerRepository.save(customer);
    }

    public Customer updateCustomerById(Customer newCustomer,Long id){

        Customer customer = this.getCustomerById(id);
        customer.setName(newCustomer.getName());
        customer.setSurname(newCustomer.getSurname());
        customer.setMail(newCustomer.getMail());
        customer.setPhone(newCustomer.getPhone());
        customer.setMobile_phone(newCustomer.getMobile_phone());
        customer.setCompany_name(newCustomer.getCompany_name());
        customer.setTax_no(newCustomer.getTax_no());
        customer.setAddress(newCustomer.getAddress());
        customer.setCustomer_type(newCustomer.getCustomer_type());

        return customerRepository.save(customer);
    }

    public void delete(long id){

        Customer customer = this.getCustomerById(id);
        customerRepository.delete(customer);
    }



}
