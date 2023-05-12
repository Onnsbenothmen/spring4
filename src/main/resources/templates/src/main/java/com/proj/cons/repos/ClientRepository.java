package com.proj.cons.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.cons.entities.Client;



public interface ClientRepository extends JpaRepository<Client, Long> {

}
