package com.app.repository;
//package com.app.dao;
//
//import javax.persistence.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.app.pojos.User;
//
//@Repository
//public class UserDaoImpl implements UserDao {
//	// dep : SF
//	@Autowired
//	private EntityManager mgr;
//
//	@Override
//	public User validateUser(String email, String pass) {
//		String jpql = "select u from User u where u.email=:em and u.password=:pass";
//
//		return mgr.
//				createQuery(jpql, User.class).
//				setParameter("em", email).setParameter("pass", pass)
//				.getSingleResult();
//	}
//
//}
