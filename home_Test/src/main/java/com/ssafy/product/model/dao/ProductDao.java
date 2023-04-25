package com.ssafy.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.product.model.dto.ProductDto;

@Component
public class ProductDao {

	@Autowired
	private DBUtil util;

	public List<ProductDto> list() throws SQLException {

		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		List<ProductDto> result = new ArrayList();

		sql = "select code, model, price from product";

		conn = util.getConnection();
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();

		while (rs.next()) {
			ProductDto product = new ProductDto();
			product.setCode(rs.getString(1));
			product.setModel(rs.getString(2));
			product.setPrice(rs.getInt(3));

			result.add(product);
		}

		util.close(rs, conn, pst);

		return result;
	}

	public int insert(ProductDto product) throws SQLException {

		Connection conn = null;
		String sql = null;
		PreparedStatement pst = null;
		int result = 0;

		sql = "insert into product (model, code, price) value(?,?,?)";

		conn = util.getConnection();
		
		
		pst = conn.prepareStatement(sql);
		
		pst.setString(1, product.getModel());
		pst.setString(2, product.getCode());
		pst.setInt(3, product.getPrice());
		
		result = pst.executeUpdate();

		util.close(conn, pst);

		System.out.println("dao들어왓니");
		return result;
	}
}
