package com.example.ec.newec.repo;

import lombok.*;

import javax.persistence.*;
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TABLE_ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int streetNo;
    @Column(nullable = false)
    private String streetName;
    private String unitNo;
    private String city;
    private String state;
    @Builder.Default
    private String country= "CANADA";
    private String zip;
    private AddressType addressType;

}
