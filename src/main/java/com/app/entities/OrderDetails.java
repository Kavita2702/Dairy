package com.app.entities;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;

	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;

	@Entity
	@Table(name = "order_detail")
	@Getter
	@Setter
	@NoArgsConstructor

	public class OrderDetails extends BaseEntity {
		private int quantity;

		private double totalPrice;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "order_id")
		private Order order;

		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "product_id")
		private Product product;

		public OrderDetails(int quantity, double totalPrice, Product product) {
			super();
			this.quantity = quantity;
			this.totalPrice = totalPrice;
			this.product = product;
		}
		

	}


