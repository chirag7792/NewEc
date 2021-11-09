package com.example.ec.newec.repo;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TABLE_PRODUCT")
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String desc;
    private double price;
    private String sku;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
