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

import com.edu.sena.models.entity.TipoProduct;
import com.edu.sena.models.service.TipoProductService;

@RestController
@RequestMapping("api/tipoproductos")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class TipoProductCtr {
	
	@Autowired
	TipoProductService tipoproductS;
	
	

	 @GetMapping("/{id}")
	    public Optional<TipoProduct> buscarPorId(@PathVariable Integer id) {

	        return tipoproductS.findById(id);
	    }

	    @GetMapping("/listar")
	    public List<TipoProduct> listarPerfiles() {

	        return tipoproductS.findAll();
	    }

	    @PostMapping
	    public TipoProduct guardar(@RequestBody TipoProduct e) {
	        return tipoproductS.save(e);

	    }

	    @DeleteMapping("{id}")
	    public void eliminar(@PathVariable Integer id) {

	        tipoproductS.deleteById(id);
	        System.out.print("Se elimino");
	    }


	


}
