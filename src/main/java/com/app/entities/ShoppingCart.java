package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.*;
@Entity
@Table(name = "carts")
@Getter
@Setter
@ToString(exclude = {"cartowner","cartitems"})
public class ShoppingCart extends BaseEntity {
private int totalitems;
private double cartprice;
@CreationTimestamp
private LocalDate createdcart;
@UpdateTimestamp
private LocalDate updatedOn;
@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "customer_id")
private User cartowner;
@OneToMany(mappedBy = "mycart", cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
private List<CartItems> cartitems=new ArrayList<>();
}
