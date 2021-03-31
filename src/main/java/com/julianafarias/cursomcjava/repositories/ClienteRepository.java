package com.julianafarias.cursomcjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julianafarias.cursomcjava.domain.Categoria;
import com.julianafarias.cursomcjava.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
