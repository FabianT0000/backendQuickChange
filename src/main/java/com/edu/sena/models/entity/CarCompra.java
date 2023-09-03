package com.edu.sena.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "carcompras")
public class CarCompra {
	
	@Id
	@Column(name = "id_car")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "observacion_carroCompras")
	private String observacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date horaSalida;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	

	@OneToMany(mappedBy = "carcompras",fetch = FetchType.EAGER,cascade =CascadeType.ALL)
	private List<ItemsCompra> itemscompra;
	
	
	public CarCompra() {
		this.itemscompra = new ArrayList<ItemsCompra>();
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public List<ItemsCompra> getItemscompra() {
		return itemscompra;
	}


	public void setItemscompra(List<ItemsCompra> itemscompra) {
		this.itemscompra = itemscompra;
	}


	public void addItemCarroCompra(ItemsCompra item) {
		this.itemscompra.add(item);
	}

	public Double getTotal() {
		Double total = 0.0;

		int size = itemscompra.size();

		for (int i = 0; i < size; i++) {
			total += itemscompra.get(i).calcularImporte();
		}
		return total;
	}

	

}
