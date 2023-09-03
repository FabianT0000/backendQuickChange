package com.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import com.edu.sena.models.entity.TipoProduct;

public interface TipoProductService {
	public Optional<TipoProduct> findById(Integer id);
	public List<TipoProduct> findAll();
	public TipoProduct save(TipoProduct e);
	public void deleteById(Integer id);
}
