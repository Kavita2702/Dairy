package com.app.repository;
//package com.app.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.app.pojos.Product;
//
//@Repository
//@Transactional
//public class ProductDaoImpl implements ProductDao {
//	// dep : Ent Manager
//	@Autowired
//	private EntityManager manager;
//
//	@Override
//	public List<Product> getProductsByCategory(long categoryId) {
//		String jpql = "select p from Product p where p.productCategory.id=:id";
//		return manager.createQuery(jpql, Product.class).setParameter("id", categoryId).getResultList();
//	}//List of detached products
//
//}
