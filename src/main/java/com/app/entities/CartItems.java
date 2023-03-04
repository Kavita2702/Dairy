package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "cart_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItems extends BaseEntity {
private int qty;
private double totalprice;
@ManyToOne
@JoinColumn(name = "cart_id")
private ShoppingCart mycart;
@OneToOne
@JoinColumn(name = "product_id")
private Product product;
}
