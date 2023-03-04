package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
//add DAL (data access logic) method for user auth.
	@Query("select u from User u left outer join fetch u.myCart where u.email=?1 and u.password=?2")
	Optional<User> validateUser(String email,String pass);
}
