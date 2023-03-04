package com.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	//dep : JPA's EntMgr
//	@PersistenceContext OR
	@Autowired
	private EntityManager mgr;

	@Override
	public List<Category> getAllCategories() {
		String jpql="select c from Category c";
		return mgr.createQuery(jpql, Category.class).getResultList();//list PERSISTENT entities
	}

}
