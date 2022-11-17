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
import br.univille.projetofinalnovostalentos.entity.Produto;
import br.univille.projetofinalnovostalentos.service.CategoriaService;
import br.univille.projetofinalnovostalentos.service.ClienteService;
import br.univille.projetofinalnovostalentos.service.ProdutoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;


    @GetMapping
    public ModelAndView index(){
        var listaCliente = service.getAll();
        return new ModelAndView("cliente/index", "listaCliente",listaCliente);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente",cliente);
        return new ModelAndView("cliente/form",dados);
    }
    @PostMapping(params = "form")
    public ModelAndView save(Cliente cliente){

        service.save(cliente);
        
        return new ModelAndView("redirect:/cliente");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umCliente = service.findById(id);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente",umCliente);
        return new ModelAndView("cliente/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/cliente");
    }
}   
