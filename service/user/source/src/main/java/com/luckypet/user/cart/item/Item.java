package com.luckypet.user.cart.item;

import com.luckypet.user.cart.Cart;
import com.luckypet.user.cart.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "_item")
public class Item {
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
