package com.senai.projetointegrador.service;

import com.senai.projetointegrador.model.Produto;
import com.senai.projetointegrador.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar produto por ID
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Salvar novo produto ou atualizar existente
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Deletar produto
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    // Pesquisar por nome
    public List<Produto> pesquisarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return listarTodos();
        }
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    // Verificar se produto existe
    public boolean existePorId(Long id) {
        return produtoRepository.existsById(id);
    }
}
