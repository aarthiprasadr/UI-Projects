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

	public DealList searchDeal(String searchName) {
		
		String searchQuery = "%"+searchName+"%";

		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where store like ? or category like ? or sub_category like ? or item like ? group by id";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					searchQuery, searchQuery, searchQuery, searchQuery },
					new DealMapper());
			DealList dealList = new DealList(list);
			return dealList;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public Deal getDeal() {
		Deal deal = new Deal();
		deal.setStore("ZZZZZZZ");
		deal.setCategory("ZZZZ");
		deal.setSub_category("ZZZZ");
		deal.setEarly_bird("early_birdzzzz");
		deal.setImg_url("urlzzz");
		deal.setProduct_url("purlzzz");
		deal.setItem("itemzzz");
		deal.setPrice("pricezzz");
		deal.setRebate("rebatezzzz");

		return deal;
	}

	public void addDeals(DealList deals) {

		String statement = "INSERT INTO black_friday.deal2014 (store, category, sub_category, item, early_bird, rebate, img_url, product_url, price) VALUES (?,?,?,?,?,?,?,?,?);";
		try {
			for (Deal deal : deals.getDeals()) {
				jdbcTemplate.update(statement, deal.getStore(),
						deal.getCategory(), deal.getSub_category(),
						deal.getItem(), deal.getEarly_bird(), deal.getRebate(),
						deal.getImg_url(), deal.getProduct_url(),
						deal.getPrice());
			}
		} catch (DataAccessException e) {
			log.error("problem adding node metrics to database"
					+ e.getMessage());
			throw e;
		}
	}

	public void addDeal(Deal deal) {
		if (deal.getId() == 0) {
			String statement = "INSERT INTO black_friday.deal2014 (store, category, sub_category, item, early_bird, rebate, img_url, product_url, price) VALUES (?,?,?,?,?,?,?,?,?);";
			try {
				jdbcTemplate.update(statement, deal.getStore(),
						deal.getCategory(), deal.getSub_category(),
						deal.getItem(), deal.getEarly_bird(), deal.getRebate(),
						deal.getImg_url(), deal.getProduct_url(),
						deal.getPrice());
			} catch (DataAccessException e) {
				log.error("problem adding node metrics to database"
						+ e.getMessage());
				throw e;
			}
		} else {
			String statement = "UPDATE black_friday.deal2014   SET store = ?, category = ?, sub_category = ?, item = ?, early_bird = ?, rebate = ?, img_url = ?, product_url = ?, price = ? WHERE id = ?;";
			try {
				jdbcTemplate.update(statement, deal.getStore(),
						deal.getCategory(), deal.getSub_category(),
						deal.getItem(), deal.getEarly_bird(), deal.getRebate(),
						deal.getImg_url(), deal.getProduct_url(),
						deal.getPrice(), deal.getId());
			} catch (DataAccessException e) {
				log.error("problem adding node metrics to database"
						+ e.getMessage());
				throw e;
			}
		}
		// addDetails(deal);
	}

	public void addDetails(Deal deal) {

		String store = deal.getStore();
		String category = deal.getCategory();
		String subCategory = deal.getSub_category();

		addStore(store);
		addCategory(category);
		addSubCategory(subCategory);
		addStoreCategory(store, subCategory);
		addStoreCategorySubCategory(store, category, subCategory);

	}

	public void addStore(String store) {
		if (!isStoreExists(store)) {
			String statement = "INSERT INTO store(name) VALUES (?)";
			try {
				jdbcTemplate.update(statement, store);

			} catch (DataAccessException e) {

			}
		}
	}

	public boolean isStoreExists(String store) {

		String sql = "SELECT EXISTS (SELECT name FROM black_friday.store where name = ?);";
		try {
			return jdbcTemplate.queryForObject(sql, Boolean.class);
		} catch (DataAccessException e) {

		}
		return false;

	}

	public void addCategory(String category) {
		if (!isCategoryExists(category)) {
			String statement = "INSERT INTO category(name) VALUES (?)";
			try {
				jdbcTemplate.update(statement, category);

			} catch (DataAccessException e) {

			}
		}
	}

	public boolean isCategoryExists(String category) {
		String sql = "SELECT EXISTS (SELECT name FROM black_friday.category where name = ?);";
		try {
			return jdbcTemplate.queryForObject(sql, new String[] { category },
					Boolean.class);
		} catch (DataAccessException e) {
		}
		return false;
	}

	public void addSubCategory(String subCategory) {
		if (!isSubCategoryExists(subCategory)) {
			String statement = "INSERT INTO sub_category(name) VALUES (?)";
			try {
				jdbcTemplate.update(statement, subCategory);

			} catch (DataAccessException e) {

			}
		}
	}

	public boolean isSubCategoryExists(String subCategory) {
		String sql = "SELECT EXISTS (SELECT name FROM black_friday.sub_category where name = ?)";
		try {
			return jdbcTemplate.queryForObject(sql,
					new String[] { subCategory }, Boolean.class);
		} catch (DataAccessException e) {
		}
		return false;
	}

	public void addStoreCategory(String store, String category) {
		if (!isStoreCategoryExists(store, category)) {
			String statement = "INSERT INTO sub_category(store, category) VALUES (?, ?)";
			try {
				jdbcTemplate.update(statement, store, category);

			} catch (DataAccessException e) {

			}
		}
	}

	public boolean isStoreCategoryExists(String store, String category) {
		String sql = "SELECT EXISTS (SELECT * FROM black_friday.store_category where store = ? AND category = ?)";
		try {
			return jdbcTemplate.queryForObject(sql, new String[] { store,
					store, category }, Boolean.class);
		} catch (DataAccessException e) {
		}
		return false;
	}

	public void addStoreCategorySubCategory(String store, String category,
			String subCategory) {
		if (isStoreCategorySubCategoryExists(store, category, subCategory)) {
			String statement = "INSERT INTO store_category_subcat(store, category, sub_category) VALUES (?, ?, ?)";
			try {
				jdbcTemplate.update(statement, store, category);

			} catch (DataAccessException e) {

			}
		}
	}

	private boolean isStoreCategorySubCategoryExists(String store,
			String category, String subCategory) {
		String sql = "SELECT EXISTS (SELECT * FROM black_friday.store_category_subcat where store = ? AND category = ? AND sub_category = ?)";
		try {
			return jdbcTemplate.queryForObject(sql, new String[] { store,
					category, subCategory }, Boolean.class);
		} catch (DataAccessException e) {
		}
		return false;
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

		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where id > ? and id <= ? order by store, category, sub_category, item";

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
		String query = "SELECT count(*) FROM black_friday.deal2014  ";
		try {
			return jdbcTemplate.queryForInt(query);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public DealList getDealsByStore(String storeName) {
		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where store = ? order by store, category, sub_category, item ";

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
		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where store = ? AND category = ? order by store, category, sub_category, item ";

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

		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where store = ? AND category = ? AND item = ? order by store, category, sub_category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					storeName, categoryName, itemName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public DealList getDealsByCategory(String categoryName) {

		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where category = ? order by store, category, sub_category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query,
					new Object[] { categoryName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public DealList getDealsByItem(String itemName) {
		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where item = ? order by store, category, sub_category, item ";

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
		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where category = ? and item = ? order by store, category, sub_category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					categoryName, itemName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	public DealList getDealsBySubCategory(String subCategoryName) {
		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where sub_category = ? order by store, category, sub_category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					subCategoryName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	public DealList getDealsByCategoryAndSubCategory(String category, String subCategoryName) {
		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where category = ? and sub_category = ? order by store, category, sub_category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					category, subCategoryName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	public DealList getDealsByStoreCategoryAndSubCategory(String store, String category, String subCategoryName) {
		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where store = ? and category = ? and sub_category = ? order by store, category, sub_category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					store, category, subCategoryName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	public DealList getDealsByStoreAndSubCategory(String store, String subCategoryName) {
		String query = "SELECT id, store, category, sub_category, item, early_bird, rebate, img_url, product_url, price FROM black_friday.deal2014  where store = ? and sub_category = ? order by store, category, sub_category, item ";

		try {
			List<Deal> list = jdbcTemplate.query(query, new Object[] {
					store, subCategoryName }, new DealMapper());
			return new DealList(list);
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	public StoreList getAllStores() {
		String query = "select distinct store from black_friday.deal2014   order by store ";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new RowMapper<String>() {

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

	public CategoryList getAllCategory() {
		String query = "select distinct category from black_friday.deal2014   order by category;";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new RowMapper<String>() {

				public String mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					storeNames.add(rs.getString("category"));
					return null;
				}

			});
			return new CategoryList(storeNames);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	public SubCategoryList getAllSubCategory() {
		String query = "select distinct sub_category from black_friday.deal2014   order by sub_category; ";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new RowMapper<String>() {

				public String mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					storeNames.add(rs.getString("sub_category"));
					return null;
				}
			});
			return new SubCategoryList(storeNames);
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
	
	public CategoryList getCategoryForSubCategory(String subCategoryName) {
		String query = "select distinct category  from deal2014 where sub_category = ?";
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new String[] { subCategoryName },
					new RowMapper<String>() {

						public String mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							storeNames.add(rs.getString("category"));
							return null;
						}

					});
			return new CategoryList(storeNames);
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	public CategoryList getCategoryForStoreAndSubCategory(String store, String subCategoryName) {
		String query = "select distinct category  from deal2014 where store = ? AND sub_category = ?";
		
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new String[] { store, subCategoryName },
					new RowMapper<String>() {

						public String mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							storeNames.add(rs.getString("category"));
							return null;
						}

					});
			return new CategoryList(storeNames);
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	
	public SubCategoryList getSubCategoryForStoreAndCategory(String store, String category) {
		String query = "select distinct sub_category  from deal2014 where store = ? AND category = ?";
		
		final List<String> storeNames = new ArrayList<String>();
		try {
			jdbcTemplate.query(query, new String[] { store, category },
					new RowMapper<String>() {

						public String mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							storeNames.add(rs.getString("sub_category"));
							return null;
						}

					});
			return new SubCategoryList(storeNames);
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
}
