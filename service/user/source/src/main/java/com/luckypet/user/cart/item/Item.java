package com.luckypet.user.cart.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luckypet.user.cart.Cart;
import com.luckypet.user.cart.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    @JsonIgnore
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cart_id")
    private Cart _cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product _product;
}
