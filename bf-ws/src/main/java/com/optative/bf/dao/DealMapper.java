package com.optative.bf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.optative.bf.vo.Deal;

public class DealMapper implements RowMapper<Deal> {

	public Deal mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Deal deal = new Deal();
		deal.setStore(resultSet.getString("store"));
		deal.setCategory(resultSet.getString("category"));
		deal.setSub_category(resultSet.getString("sub_category"));
		deal.setItem(resultSet.getString("item"));
		deal.setEarly_bird(resultSet.getString("early_bird"));
		deal.setRebate(resultSet.getString("rebate"));
		deal.setImg_url(resultSet.getString("img_url"));
		deal.setProduct_url(resultSet.getString("product_url"));
		deal.setPrice(resultSet.getString("price"));
		return deal;
	}
}
