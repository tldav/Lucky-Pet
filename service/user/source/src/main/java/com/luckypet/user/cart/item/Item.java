package com.luckypet.user.cart.item;

import com.luckypet.user.cart.Cart;
import com.luckypet.user.cart.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "item_id", nullable = false)
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart _cart;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product _product;
}
