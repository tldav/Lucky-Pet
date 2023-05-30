package com.luckypet.user.cart;

import com.luckypet.user.cart.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "_cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id", columnDefinition = "INT NOT NULL AUTO_INCREMENT")
    @Getter @Setter
    private int id;

    @OneToMany(mappedBy = "_cart")
    private List<Item> itemList;
}
