package com.luckypet.user.cart.product;

import com.luckypet.user.cart.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "product_id", nullable = false)
    private int id;
    @OneToOne(mappedBy = "_product")
    private Item _item;
}
