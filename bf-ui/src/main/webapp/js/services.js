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
					url : 'http://104.130.240.61:8080/bf-ws/deals/store/' + $store
				});
			}

			bfAPI.getDealsByCategory = function($category, $store) {
				if (angular.isUndefined($store) || $store == null) {
					return $http({
						method : 'GET',
						headers : {
							'accept' : 'application/json'
						},
						url : 'http://104.130.240.61:8080/bf-ws/deals/category/'
								+ $category
					});
				} else {
					return $http({
						method : 'GET',
						headers : {
							'accept' : 'application/json'
						},
						url : 'http://104.130.240.61:8080/bf-ws/deals/store/'
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
					url : 'http://104.130.240.61:8080/bf-ws/deals'
				});
			}

			bfAPI.getStores = function() {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://104.130.240.61:8080/bf-ws/stores'
				});
			}

			bfAPI.getCategories = function() {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://104.130.240.61:8080/bf-ws/category'
				});
			}
			
			bfAPI.getSubCategories = function() {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://104.130.240.61:8080/bf-ws/sub-category'
				});
			}

			bfAPI.getCategoriesByStore = function($store) {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://104.130.240.61:8080/bf-ws/store-config/store/'
							+ $store
				});
			}
			
			
			bfAPI.getDealsByStoreCategory = function($store, $category) {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://104.130.240.61:8080/bf-ws/deals/store/'+$store+'/category/'+$category
				});
			}

			bfAPI.getStoresByCategory = function($category) {
				return $http({
					method : 'GET',
					headers : {
						'accept' : 'application/json'
					},
					url : 'http://104.130.240.61:8080/bf-ws/stores/category/'+$category
				});
			}

			
			return bfAPI;
		});