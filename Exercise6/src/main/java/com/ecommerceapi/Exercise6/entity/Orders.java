package com.ecommerceapi.Exercise6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String customerName;

    @OneToMany(mappedBy = "orders" , cascade = CascadeType.ALL)
    private List<OrderItem> items;

}
