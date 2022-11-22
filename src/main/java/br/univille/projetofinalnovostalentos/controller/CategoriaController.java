package br.univille.projetofinalnovostalentos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetofinalnovostalentos.entity.Categoria;
import br.univille.projetofinalnovostalentos.service.CategoriaService;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping
    public ModelAndView index(){
        var listaCategorias = service.getAll();
        return new ModelAndView("categoria/index", "listaCategorias",listaCategorias);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaCategoria = new Categoria();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("categoria",novaCategoria);
        return new ModelAndView("categoria/form",dados);
    }
    @PostMapping(params = "form")
    public ModelAndView save(Categoria categoria){

        service.save(categoria);
        
        return new ModelAndView("redirect:/categoria");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umaCategoria = service.findById(id);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("categoria",umaCategoria);
        return new ModelAndView("categoria/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/categoria");
    }
}   

