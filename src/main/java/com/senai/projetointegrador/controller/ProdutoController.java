package com.senai.projetointegrador.controller;

import com.senai.projetointegrador.model.Produto;
import com.senai.projetointegrador.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Pagina inicial - lista todos os produtos
    @GetMapping
    public String listar(@RequestParam(required = false) String pesquisa, Model model) {
        if (pesquisa != null && !pesquisa.isEmpty()) {
            model.addAttribute("produtos", produtoService.pesquisarPorNome(pesquisa));
            model.addAttribute("pesquisa", pesquisa);
        } else {
            model.addAttribute("produtos", produtoService.listarTodos());
        }
        return "produtos/lista";
    }

    // Formulario para novo produto
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/form";
    }

    // Salvar novo produto
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Produto produto,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "produtos/form";
        }

        produtoService.salvar(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
        return "redirect:/produtos";
    }

    // Formulario para editar produto
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return produtoService.buscarPorId(id)
                .map(produto -> {
                    model.addAttribute("produto", produto);
                    return "produtos/form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("erro", "Produto não encontrado");
                    return "redirect:/produtos";
                });
    }

    // Deletar produto
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (produtoService.existePorId(id)) {
            produtoService.deletar(id);
            redirectAttributes.addFlashAttribute("mensagem", "Produto excluído com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Produto não encontrado");
        }
        return "redirect:/produtos";
    }
}
