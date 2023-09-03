package com.edu.sena.controller;

import java.util.List;
import java.util.Map;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.sena.models.entity.CarCompra;
import com.edu.sena.models.entity.Usuario;
import com.edu.sena.models.service.CarCompraService;
import com.edu.sena.models.service.UsuarioService;


@RestController
@RequestMapping("api/carcompras")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CarCompraCtr {

	@Autowired
	CarCompraService carcompraS;
	@Autowired
	UsuarioService userService;
	
	
	 @GetMapping("/{id}")
	    public Optional<CarCompra> buscarPorId(@PathVariable Integer id) {

	        return carcompraS.findById(id);
	    }
	 
	 @GetMapping("/form/{usuarioId}")
		public String crear(@PathVariable(value = "usuarioId") Integer usuarioId, Map<String, Object> model,
				RedirectAttributes flash) {

			Usuario cliente = userService.findById(usuarioId).get();

			if (cliente == null) {
				flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
				return "redirect:/listar";
			}

			CarCompra factura = new CarCompra();
			factura.setUsuario(cliente);

			model.put("factura", factura);
			model.put("titulo", "Crear Factura");

			return "factura/form";
		}

	    @GetMapping("/listar")
	    public List<CarCompra> listarPerfiles() {

	        return carcompraS.findAll();
	    }

	    @PostMapping
	    public CarCompra guardar(@RequestBody CarCompra e) {
	        return carcompraS.save(e);

	    }

	    @DeleteMapping("{id}")
	    public void eliminar(@PathVariable Integer id) {

	        carcompraS.deleteById(id);
	        System.out.print("Se elimino");
	    }
	
	
	
	
}
