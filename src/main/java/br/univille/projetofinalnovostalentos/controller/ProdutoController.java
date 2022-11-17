package br.univille.projetofinalnovostalentos.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetofinalnovostalentos.entity.Categoria;
import br.univille.projetofinalnovostalentos.entity.Produto;
import br.univille.projetofinalnovostalentos.service.CategoriaService;
import br.univille.projetofinalnovostalentos.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ModelAndView index(){
        var listaProdutos = service.getAll();
        return new ModelAndView("produto/index", "listaProdutos",listaProdutos);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var produto = new Produto();
        var listaCategorias = categoriaService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("produto",produto);
        dados.put("listaCategorias",listaCategorias);
        return new ModelAndView("produto/form",dados);
    }
    @PostMapping(params = "form")
    public ModelAndView save(@Validated Produto produto,
                            BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            var listaCategorias = categoriaService.getAll();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("produto",produto);
            dados.put("listaCategorias",listaCategorias);
            return new ModelAndView("cliente/form",dados);
        }
        service.save(produto);

        return new ModelAndView("redirect:/produto");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umProduto = service.findById(id);
        var listaCategorias = categoriaService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("produto",umProduto);
        dados.put("listaCategorias",listaCategorias);
        return new ModelAndView("produto/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/produto");
    }
}   
