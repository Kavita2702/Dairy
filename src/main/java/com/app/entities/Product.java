package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="products")
@Entity
public class Product extends BaseEntity {
	@Column(name="product_name",length=30, unique=true)
	private String productName;
private double price;
@Column(length=300)
private String discription;
@Column(name="in_stock")
private boolean in_stock;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "category_id" ,nullable = false ) //FK col name
private Category productCategory;


}
