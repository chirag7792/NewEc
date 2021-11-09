package com.example.ec.newec.repo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Table_Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-mm-yyyy hh:mm:ss")
    private Date createDate;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-mm-yyyy hh:mm:ss")
    private Date updateDate;
    @JsonIgnore
    private String password;
    private Status status;
    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn(name = "address_ID")
    private Address address;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Product> products;

}
