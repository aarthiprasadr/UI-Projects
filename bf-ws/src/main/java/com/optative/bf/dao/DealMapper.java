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
		deal.setItem(resultSet.getString("item"));
		deal.setEarly_bird(resultSet.getString("early_bird"));
		deal.setRebate(resultSet.getString("rebate"));
		deal.setPrice(resultSet.getString("price"));
		return deal;
	}
}