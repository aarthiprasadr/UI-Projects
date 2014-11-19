/**
 * Notification Service Module
 */
angular
		.module('bfApp.services', [])
		.factory(
				'bfService',
				function($http) {

					var bfAPI = {};
					bfAPI.getDealsByStore = function($store) {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://www.fridaywallet.com/bf-ws/deals/store/'
									+ $store + '.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.getDealsByCategory = function($category, $store) {
						if (angular.isUndefined($store) || $store == null) {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://www.fridaywallet.com/bf-ws/deals/category/'
										+ $category
										+ '.json?callback=JSON_CALLBACK'
							});
						} else {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://www.fridaywallet.com/bf-ws/deals/store/'
										+ $store
										+ '/category/'
										+ $category
										+ '.json?callback=JSON_CALLBACK'

							});
						}
					}

					bfAPI.getDeals = function() {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://www.fridaywallet.com/bf-ws/deals.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.getStores = function() {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://www.fridaywallet.com/bf-ws/stores.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.getCategories = function() {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://www.fridaywallet.com/bf-ws/category.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.getSubCategories = function() {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://www.fridaywallet.com/bf-ws/sub-category.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.getCategoriesByStore = function($store) {
						if (!angular.isUndefined($store) || $store != null) {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://www.fridaywallet.com/bf-ws/store-config/store/'
										+ $store
										+ '.json?callback=JSON_CALLBACK'
							});
						} else {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://www.fridaywallet.com/bf-ws/category.json?callback=JSON_CALLBACK'
							});
						}
					}

					bfAPI.getDealsByStoreCategory = function($store, $category) {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://www.fridaywallet.com/bf-ws/deals/store/'
									+ $store + '/category/' + $category
									+ '.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.isMobile = function() {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://www.fridaywallet.com/bf-ws/detect-device.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.getStoresByCategory = function($category) {
						if (!angular.isUndefined($category)
								|| $category != null) {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://www.fridaywallet.com/bf-ws/stores/category/'
										+ $category
										+ '.json?callback=JSON_CALLBACK'
							});
						} else {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://www.fridaywallet.com/bf-ws/stores.json?callback=JSON_CALLBACK'
							});
						}
					}
					

					return bfAPI;
				});
