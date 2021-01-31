package com.digitalact.first.project.demo.Customer;


import com.digitalact.first.project.demo.AuditModel;
import com.digitalact.first.project.demo.Customer.Enums.CustomerType;
import com.digitalact.first.project.demo.Order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "customer")
public class Customer extends AuditModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String surname;
    private String mail;
    private String phone;
    private String mobile_phone;
    private String company_name;
    private long tax_no;
    @Lob
    private String address;

    @Enumerated(EnumType.STRING)
    private CustomerType customer_type;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List < Order > orders;

    public Customer(){}


    public Customer(long id, String name, String surname, String mail, String phone, String mobile_phone, String company_name, long tax_no, String address, CustomerType customer_type, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.mobile_phone = mobile_phone;
        this.company_name = company_name;
        this.tax_no = tax_no;
        this.address = address;
        this.customer_type = customer_type;
        this.orders = orders;
    }

}
