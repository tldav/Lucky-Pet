package com.luckypet.user.cart.item;

import com.luckypet.user.cart.Cart;
import com.luckypet.user.cart.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart _cart;

    @OneToOne(mappedBy = "_item")
    private Product _product;
}
