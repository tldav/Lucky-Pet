package com.luckypet.user.cart.product;

import com.luckypet.user.cart.item.Item;
import jakarta.persistence.*;

@Entity
@Table(name = "_product")
public class Product {
    @Id
    @Column(name = "product_id", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
    private int id;
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item _item;
}
