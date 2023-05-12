package com.ons.plats.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ons.plats.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

		User findByUsername(String username);

}
