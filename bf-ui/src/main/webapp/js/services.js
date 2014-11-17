/**
 * Notification Service Module
 */
angular.module('bfApp.services', []).factory(
		'bfService',
		function($http) {

			var bfAPI = {};
			bfAPI.getDealsByStore = function($store) {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://www.fridaywallet.com/bf-ws/deals/store/' + $store
				});
			}

			bfAPI.getDealsByCategory = function($category, $store) {
				if (angular.isUndefined($store) || $store == null) {
					return $http({
						method : 'GET',
						headers : {
							'accept' : 'application/json'
						},
						url : 'http://www.fridaywallet.com/bf-ws/deals/category/'
								+ $category
					});
				} else {
					return $http({
						method : 'GET',
						headers : {
							'accept' : 'application/json'
						},
						url : 'http://www.fridaywallet.com/bf-ws/deals/store/'
								+ $store + '/category/' + $category

					});
				}
			}

			bfAPI.getDeals = function() {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://www.fridaywallet.com/bf-ws/deals'
				});
			}

			bfAPI.getStores = function() {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://www.fridaywallet.com/bf-ws/stores'
				});
			}

			bfAPI.getCategories = function() {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://www.fridaywallet.com/bf-ws/category'
				});
			}

			bfAPI.getSubCategories = function() {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://www.fridaywallet.com/bf-ws/sub-category'
				});
			}

			bfAPI.getCategoriesByStore = function($store) {
				if (!angular.isUndefined($store) || $store != null) {
					return $http({
						method : 'GET',
						headers : {
							'accept' : 'application/json'
						},
						url : 'http://www.fridaywallet.com/bf-ws/store-config/store/'
								+ $store
					});
				} else {
					return $http({
						method : 'GET',
						headers : {
							'accept' : 'application/json'
						},
						url : 'http://www.fridaywallet.com/bf-ws/category'
					});
				}
			}

			bfAPI.getDealsByStoreCategory = function($store, $category) {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://www.fridaywallet.com/bf-ws/deals/store/' + $store
							+ '/category/' + $category
				});
			}
			
			bfAPI.isMobile = function() {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://www.fridaywallet.com/bf-ws/detect-device'
				});
			}

			bfAPI.getStoresByCategory = function($category) {
				if (!angular.isUndefined($category) || $category != null) {
					return $http({
						method : 'GET',
						headers : {
							'accept' : 'application/json'
						},
						url : 'http://www.fridaywallet.com/bf-ws/stores/category/'
								+ $category
					});
				} else {
					return $http({
						method : 'GET',
						headers : {
							'accept' : 'application/json'
						},
						url : 'http://www.fridaywallet.com/bf-ws/stores'
					});
				}
			}

			return bfAPI;
		});
