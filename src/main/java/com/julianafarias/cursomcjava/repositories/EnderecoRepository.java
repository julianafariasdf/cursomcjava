package com.julianafarias.cursomcjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julianafarias.cursomcjava.domain.Categoria;
import com.julianafarias.cursomcjava.domain.Cidade;
import com.julianafarias.cursomcjava.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
