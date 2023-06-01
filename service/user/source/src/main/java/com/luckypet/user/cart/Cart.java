package com.luckypet.user.cart;

import com.luckypet.user.cart.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "_cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "cart_id", nullable = false)
    private int id;
    @OneToMany(mappedBy = "_cart")
    private List<Item> itemList;
}
