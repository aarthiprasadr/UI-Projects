package com.optative.bf.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.optative.bf.vo.Deal;
import com.optative.bf.vo.DealList;

@Component
public class BlackFridayDao {

	@Resource
	private DataSource mysqldataSource;

	private JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory
			.getLogger(BlackFridayDao.class);

	@PostConstruct
	public void init() {
		jdbcTemplate = new JdbcTemplate(mysqldataSource);

	}

	public void addDeal(DealList deals) {

		String statement = "INSERT INTO d2012(store,category,item,early_bird,rebate,price) VALUES (?,?,?,?,?,?);";
		try {
			for (Deal deal : deals.getDeals()) {
				jdbcTemplate
						.update(statement, deal.getStore(), deal.getCategory(),
								deal.getItem(), deal.getEarly_bird(),
								deal.getRebate(), deal.getPrice());
			}
		} catch (DataAccessException e) {
			log.error("problem adding node metrics to database"
					+ e.getMessage());
			throw e;
		}

	}

	public DealList getDealsByStore(String storeName) {

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.d2012 where store = ? order by store, category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query,
					new Object[] { storeName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public DealList getDealsByStoreAndCategory(String storeName,
			String categoryName) {
		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.d2012 where store = ? AND category = ? order by store, category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					storeName, categoryName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public DealList getDealsByStoreAndCategoryAndItem(String storeName,
			String categoryName, String itemName) {

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.d2012 where store = ? AND category = ? AND item = ? order by store, category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					storeName, categoryName, itemName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}

	}

	public DealList getDealsByCategory(String categoryName) {

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.d2012 where category = ? order by store, category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query,
					new Object[] { categoryName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public DealList getDealsByItem(String itemName) {

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.d2012 where item = ? order by store, category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query,
					new Object[] { itemName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public DealList getDealsByCategoryAndItem(String categoryName,
			String itemName) {

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.d2012 where category = ? and item = ? order by store, category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					categoryName, itemName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}

}
