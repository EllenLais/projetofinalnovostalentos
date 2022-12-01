package br.univille.projetofinalnovostalentos.controller;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetofinalnovostalentos.entity.Compra;
import br.univille.projetofinalnovostalentos.entity.ItemCompra;
import br.univille.projetofinalnovostalentos.entity.ItemVenda;
import br.univille.projetofinalnovostalentos.service.CompraService;
import br.univille.projetofinalnovostalentos.service.FornecedorService;
import br.univille.projetofinalnovostalentos.service.ProdutoService;


@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService service;
    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public ModelAndView index(){
        var listaCompras = service.getAll();
        return new ModelAndView("compra/index",
                    "listaCompras",listaCompras);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var novaCompra = new Compra();
        var listaFornecedor = fornecedorService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("compra", novaCompra);
        dados.put("listaFornecedor", listaFornecedor);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemCompra());
        return new ModelAndView("compra/form",dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(@Validated Compra compra,
                            BindingResult bindingResult){
        service.save(compra);
        return new ModelAndView("redirect:/compras");
    }
    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Compra compra, ItemCompra novoItem){
        compra.getColItens().add(novoItem);

        var listaFornecedor = fornecedorService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("compra", compra);
        dados.put("listaFornecedor", listaFornecedor);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemCompra());
        return new ModelAndView("compra/form",dados);
    }
    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem")int index,
                                   Compra compra){
        compra.getColItens().remove(index);

        var listaFornecedor = fornecedorService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("compra", compra);
        dados.put("listaFornecedor", listaFornecedor);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemCompra());
        return new ModelAndView("compra/form",dados);
    }
}