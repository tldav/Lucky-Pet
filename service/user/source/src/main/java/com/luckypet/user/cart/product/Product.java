package com.luckypet.user.cart.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luckypet.user.cart.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private int id;

    private int price;
    private String description;
    private int stock;
    
    @OneToMany(mappedBy = "_product")
    @JsonIgnore
    private List<Item> itemList;
}
