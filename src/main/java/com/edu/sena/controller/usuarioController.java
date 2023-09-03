package com.edu.sena.controller;

import java.io.Console;
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


import com.edu.sena.models.entity.Usuario;

import com.edu.sena.models.service.UsuarioService;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class usuarioController {

    @Autowired
    UsuarioService usuarioservice;

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable Integer id) {
    	System.out.print("consulto");
    	System.out.print("");
    	System.out.print(usuarioservice.findById(id).toString());
    	
    	
        return usuarioservice.findById(id);
    }

    @GetMapping("/listar")
    public List<Usuario> listarClientes() {
    	

        return usuarioservice.findAll();
       
    }
    
    

    @PostMapping
    public Usuario guardar(@RequestBody Usuario e) {
    	System.out.print("se va a guardar");
    
        return usuarioservice.save(e);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario cliente) {
    	
        String mensaje = usuarioservice.login(cliente.getUsername(), cliente.getContrasena());
        System.out.print(mensaje);
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Integer id) {

        usuarioservice.deleteById(id);
        System.out.print("Se elimino");
    }
    
    @PostMapping("/actualizar")
    public Usuario actualizar(@RequestBody Usuario e) {
      return usuarioservice.save(e);
      }

    @PostMapping("/actualizar/{id}")
    public Usuario actualizar(@RequestBody Usuario e, @PathVariable Integer id) {

        Usuario usuarioBd = usuarioservice.findById(id).get();

//		clienteBd.setTipo_usuario(e.getTipo_usuario());
        usuarioBd.setNombres(e.getNombres());
        usuarioBd.setApellidos(e.getApellidos());
        usuarioBd.setTipo_documento(e.getTipo_documento());
        usuarioBd.setnDocumento(e.getnDocumento());
        usuarioBd.setTelefono(e.getTelefono());
        usuarioBd.setPais(e.getPais());
        usuarioBd.setCiudad(e.getCiudad());
        usuarioBd.setCorreo(e.getCorreo());
        usuarioBd.setUsername(e.getUsername());
        usuarioBd.setContrasena(e.getContrasena());
        usuarioBd.setDireccion(e.getDireccion());
        usuarioBd.setBarrio(e.getBarrio());

        return usuarioservice.save(usuarioBd);

    }
}
