package com.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.sena.models.entity.TipoProduct;
import com.edu.sena.repository.TipoProductoRepository;

@Service
public class TipoProductServiceimpl implements TipoProductService{
		@Autowired
		
		TipoProductoRepository tipoproductR;
	@Override
	public Optional<TipoProduct> findById(Integer id) {
		// TODO Auto-generated method stub
		return tipoproductR.findById(id);
	}

	@Override
	public List<TipoProduct> findAll() {
		// TODO Auto-generated method stub
		return tipoproductR.findAll();
	}

	@Override
	public TipoProduct save(TipoProduct e) {
		// TODO Auto-generated method stub
		return tipoproductR.save(e);
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		tipoproductR.deleteById(id);
	}

}
