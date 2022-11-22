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
import br.univille.projetofinalnovostalentos.entity.Cliente;
import br.univille.projetofinalnovostalentos.entity.Fornecedor;
import br.univille.projetofinalnovostalentos.entity.Produto;
import br.univille.projetofinalnovostalentos.service.CategoriaService;
import br.univille.projetofinalnovostalentos.service.ClienteService;
import br.univille.projetofinalnovostalentos.service.FornecedorService;
import br.univille.projetofinalnovostalentos.service.ProdutoService;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService service;


    @GetMapping
    public ModelAndView index(){
        var listaFornecedor = service.getAll();
        return new ModelAndView("fornecedor/index", "listaFornecedor",listaFornecedor);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var fornecedor = new Fornecedor();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("fornecedor",fornecedor);
        return new ModelAndView("fornecedor/form",dados);
    }
    @PostMapping(params = "form")
    public ModelAndView save(Fornecedor fornecedor){

        service.save(fornecedor);
        
        return new ModelAndView("redirect:/fornecedor");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umFornecedor = service.findById(id);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("fornecedor",umFornecedor);
        return new ModelAndView("fornecedor/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/fornecedor");
    }
}   