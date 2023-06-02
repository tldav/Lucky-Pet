package com.luckypet.user.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Getter @Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private int id;


    @OneToMany(mappedBy = "_cart")
    private List<Item> itemList;
}
