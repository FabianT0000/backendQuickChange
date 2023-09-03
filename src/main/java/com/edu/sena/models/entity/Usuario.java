package com.edu.sena.models.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "usuarios")
@Table(name = "usuarios")
public class Usuario {

	
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombreuser")
	private String nombres;
	@Column(name = "apellidosuser")
	private String apellidos;
	@Column(name = "tipodocumuser")
	private String tipo_documento;
	@Column(name = "ndocumuser")
	private String nDocumento;
	@Column(name = "teluser")
	private String telefono;
	@Column(name = "pais_user")
	private String pais;
	@Column(name = "ciudad_user")
	private String ciudad;
	@Column(name = "correo_user")
	private String correo;
	@Column(name = "nomusuariouser")
	private String username;
	@Column(name = "passwuser")
	private String contrasena;
	@Column(name = "direccionuser")
	private String direccion;
	@Column(name = "barriouser")
	private String barrio;

	@OneToOne
	@JoinColumn(name = "id_perfil", unique = false)
	private Perfil perfil;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CarCompra> carcompras;


	public Usuario() {
		carcompras = new ArrayList<CarCompra>();
	}
	

	
	public Usuario(String nombres, String apellidos, String tipo_documento, String nDocumento, String telefono,
			String pais, String ciudad, String correo, String username, String contrasena, String direccion,
			String barrio, Perfil perfil, List<CarCompra> carcompras) {
	
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipo_documento = tipo_documento;
		this.nDocumento = nDocumento;
		this.telefono = telefono;
		this.pais = pais;
		this.ciudad = ciudad;
		this.correo = correo;
		this.username = username;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.barrio = barrio;
		this.perfil = perfil;
		this.carcompras = carcompras;
	}



	public void cliente(Usuario user) {
		user.getPerfil().toString();
			
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getnDocumento() {
		return nDocumento;
	}

	public void setnDocumento(String nDocumento) {
		this.nDocumento = nDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<CarCompra> getCarcompras() {
		return carcompras;
	}

	public void setCarcompras(List<CarCompra> carcompras) {
		this.carcompras = carcompras;
	}
	public void addFactura(CarCompra carrocompra) {
		carcompras.add(carrocompra);
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", tipo_documento="
				+ tipo_documento + ", nDocumento=" + nDocumento + ", telefono=" + telefono + ", pais=" + pais
				+ ", ciudad=" + ciudad + ", correo=" + correo + ", username=" + username + ", contrasena=" + contrasena
				+ ", direccion=" + direccion + ", barrio=" + barrio + ", perfil=" + perfil + ", carcompras="
				+ carcompras + "]";
	}
	

}
