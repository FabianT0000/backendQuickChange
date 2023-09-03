package com.edu.sena.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.sena.models.entity.ItemsCompra;
import com.edu.sena.models.service.ItemCompraService;

@RestController
@RequestMapping("api/itemcompra")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ItemCompraCtr {
		
	@Autowired
	ItemCompraService itemcompraS;
	
	 @GetMapping("/{id}")
	    public Optional<ItemsCompra> buscarPorId(@PathVariable Integer id) {

	        return itemcompraS.findById(id);
	    }

	    @GetMapping("/listar")
	    public List<ItemsCompra> listarPerfiles() {

	        return itemcompraS.findAll();
	    }

	    @PostMapping
	    public ItemsCompra guardar(@RequestBody ItemsCompra e) {
	        return itemcompraS.save(e);

	    }

	    @DeleteMapping("{id}")
	    public void eliminar(@PathVariable Integer id) {

	        itemcompraS.deleteById(id);
	        System.out.print("Se elimino");
	    }
	
	
	

	
	
}
