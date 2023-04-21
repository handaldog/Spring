package com.ssafy.product.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dto.ProductDto;

@Component
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public List<ProductDto> selectAll() throws SQLException{
		return dao.list();
	}
	
}
