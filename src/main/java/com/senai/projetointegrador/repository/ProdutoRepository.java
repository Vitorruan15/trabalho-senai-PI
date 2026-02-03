package com.senai.projetointegrador.repository;

import com.senai.projetointegrador.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Buscar produtos pelo nome (case insensitive)
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    // Buscar por categoria
    List<Produto> findByCategoria(String categoria);
}
