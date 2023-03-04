package com.app.entities;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

	@MappedSuperclass // mandatory cls level anno to tell hibernate that following is a common base
		@Getter
		@Setter// class to extend entities , no table generation
	public class BaseEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		

	}


