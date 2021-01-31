package com.digitalact.first.project.demo.Order;

import com.digitalact.first.project.demo.AuditModel;
import com.digitalact.first.project.demo.Customer.Customer;
import com.digitalact.first.project.demo.Order.Enums.OrderType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="orders")
public class Order extends AuditModel {


    @Id
    @GeneratedValue
    private long id;

    //@Column(length = 5,nullable = true)
    @Size(min = 0, max = 500, message = "Max 500 karakter girebilirsiniz.")
    private String description;

    @Enumerated(EnumType.STRING)
    private OrderType status;


    @JsonFormat(pattern="dd/MM/yyyy")
    private Date createdDate;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(){}

    public Order(long id, @Size(min = 0, max = 500, message = "Max 500 karakter girebilirsiniz.") String description, OrderType status, Date createdDate, Customer customer) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
        //this.customer = customer;
    }
}
