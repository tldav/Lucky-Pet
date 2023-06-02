package com.luckypet.user.cart.product;

import com.luckypet.user.cart.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne(mappedBy = "_product")
    private Item _item;
}
