package com.optative.bf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.optative.bf.vo.CategoryConfig;
import com.optative.bf.vo.CategoryList;
import com.optative.bf.vo.Deal;
import com.optative.bf.vo.DealList;
import com.optative.bf.vo.StoreConfig;
import com.optative.bf.vo.StoreList;
import com.optative.bf.vo.SubCategoryList;

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

		String statement = "INSERT INTO deal(store,category,item,early_bird,rebate,price) VALUES (?,?,?,?,?,?);";
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

	public DealList getAllDeals(int marker, int limit) {
		int initialMarker = marker;
		marker = marker - 1;
		int startIndex = limit * marker;
		int endIndex = startIndex + limit + 1;
		int totalCount = getTotalCount();
		int totalPages = totalCount / limit;
		if (totalCount > limit * totalPages) {
			totalPages++;
		}

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.deal where id > ? and id <= ? order by store, category, item";
		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					startIndex, endIndex }, new DealMapper());
			DealList dealList = new DealList(list);
			dealList.setLimit(limit);
			dealList.setMarker(initialMarker);
			dealList.setTotalPages(totalPages);
			return dealList;
		} catch (DataAccessException e) {
			throw e;
		}

	}

	public int getTotalCount() {

		String query = "SELECT  count(*) FROM black_friday.deal ";
		try {
			return jdbcTemplate.queryForInt(query);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public DealList getDealsByStore(String storeName) {

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.deal where store = ? order by store, category, item ";

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
		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.deal where store = ? AND category = ? order by store, category, item ";

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

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.deal where store = ? AND category = ? AND item = ? order by store, category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					storeName, categoryName, itemName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}

	}

	public DealList getDealsByCategory(String categoryName) {

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.deal where category = ? order by store, category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query,
					new Object[] { categoryName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public DealList getDealsByItem(String itemName) {

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.deal where item = ? order by store, category, item ";

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

		String query = "SELECT  store, category, item, early_bird, rebate, price FROM black_friday.deal where category = ? and item = ? order by store, category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					categoryName, itemName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public StoreList getAllStores() {

		String query = "SELECT  name FROM black_friday.store order by name ";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new RowMapper<String>() {

				public String mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					storeNames.add(rs.getString("name"));
					return null;
				}

			});
			return new StoreList(storeNames);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public CategoryList getAllCategory() {

		String query = "SELECT  name FROM black_friday.category order by name";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new RowMapper<String>() {

				public String mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					storeNames.add(rs.getString("name"));
					return null;
				}

			});
			return new CategoryList(storeNames);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public SubCategoryList getAllSubCategory() {

		String query = "SELECT  name FROM black_friday.sub_category order by name ";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new RowMapper<String>() {

				public String mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					storeNames.add(rs.getString("name"));
					return null;
				}

			});
			return new SubCategoryList(storeNames);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public StoreConfig getStoreConfig(String storeName) {
		String query = "select category, sub_category from store_category_subcat where store = ?";
		final Map<String, CategoryConfig> configs = new HashMap<String, CategoryConfig>();
		try {
			jdbcTemplate.query(query, new String[] { storeName },
					new RowMapper<String>() {

						public String mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							String categoryName = rs.getString("category");
							String subCategory = rs.getString("sub_category");
							CategoryConfig subCatList = configs
									.get(categoryName);
							if (subCatList == null) {
								subCatList = new CategoryConfig();
								subCatList.setCategoryName(categoryName);
								configs.put(categoryName, subCatList);
							}
							subCatList.addSubCategory(subCategory);
							return null;
						}

					});

			return new StoreConfig(new ArrayList<CategoryConfig>(
					configs.values()));
		} catch (DataAccessException e) {
			throw e;
		}

	}

	public CategoryList getCategoryConfig(String storeName, String categoryName) {
		String query = "select sub_category from store_category_subcat where store = ? and category = ?";
		final CategoryList configs = new CategoryList();
		try {
			jdbcTemplate.query(query, new String[] { storeName, categoryName },
					new RowMapper<String>() {

						public String mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							String subCategory = rs.getString("sub_category");
							configs.addCategoryNames(subCategory);
							return null;
						}

					});

			return configs;
		} catch (DataAccessException e) {
			throw e;
		}

	}

	public StoreList getStoresForCategory(String categoryName) {
		String query = "select distinct store from store_category_subcat where category = ?";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new String[] { categoryName },
					new RowMapper<String>() {

						public String mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							storeNames.add(rs.getString("store"));
							return null;
						}

					});
			return new StoreList(storeNames);
		} catch (DataAccessException e) {
			throw e;
		}

	}

	public StoreList getStoresForSubCategory(String subCategoryName) {
		String query = "select distinct store from store_category_subcat where sub_category = ?";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new String[] { subCategoryName },
					new RowMapper<String>() {

						public String mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							storeNames.add(rs.getString("store"));
							return null;
						}

					});
			return new StoreList(storeNames);
		} catch (DataAccessException e) {
			throw e;
		}

	}

	public StoreList getStoresForCategoryAndSubCategory(String categoryName,
			String subCategoryName) {
		String query = "select distinct store from store_category_subcat where category= ? and sub_category = ?";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new String[] { categoryName,
					subCategoryName }, new RowMapper<String>() {

				public String mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					storeNames.add(rs.getString("store"));
					return null;
				}

			});
			return new StoreList(storeNames);
		} catch (DataAccessException e) {
			throw e;
		}

	}

}
