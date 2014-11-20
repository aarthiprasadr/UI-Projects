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
							url : 'http://104.130.240.83:8080/bf-ws/deals/store/'
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
								url : 'http://104.130.240.83:8080/bf-ws/deals/category/'
										+ $category
										+ '.json?callback=JSON_CALLBACK'
							});
						} else {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://104.130.240.83:8080/bf-ws/deals/store/'
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
							url : 'http://104.130.240.83:8080/bf-ws/deals.json?callback=JSON_CALLBACK&limit=1000'
						});
					}

					bfAPI.getStores = function() {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://104.130.240.83:8080/bf-ws/stores.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.getCategories = function() {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://104.130.240.83:8080/bf-ws/category.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.getSubCategories = function() {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://104.130.240.83:8080/bf-ws/sub-category.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.getCategoriesByStore = function($store) {
						if (!angular.isUndefined($store) || $store != null) {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://104.130.240.83:8080/bf-ws/store-config/store/'
										+ $store
										+ '.json?callback=JSON_CALLBACK'
							});
						} else {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://104.130.240.83:8080/bf-ws/category.json?callback=JSON_CALLBACK'
							});
						}
					}

					bfAPI.getDealsByStoreCategory = function($store, $category) {
						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://104.130.240.83:8080/bf-ws/deals/store/'
									+ $store
									+ '/category/'
									+ $category
									+ '.json?callback=JSON_CALLBACK'
						});
					}

					bfAPI.isMobile = function() {

						return $http({
							method : 'JSONP',
							headers : {
								'accept' : 'application/json'
							},
							url : 'http://104.130.240.83:8080/bf-ws/detect-device.json?callback=JSON_CALLBACK'
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
								url : 'http://104.130.240.83:8080/bf-ws/stores/category/'
										+ $category
										+ '.json?callback=JSON_CALLBACK'
							});
						} else {
							return $http({
								method : 'JSONP',
								headers : {
									'accept' : 'application/json'
								},
								url : 'http://104.130.240.83:8080/bf-ws/stores.json?callback=JSON_CALLBACK'
							});
						}
					}

					return bfAPI;
				})
		.config(function($httpProvider) {
			$httpProvider.responseInterceptors.push('myHttpInterceptor');
			var spinnerFunction = function(data, headersGetter) {
				// todo start the spinner here
				$('#loading').show();
				return data;
			};
			$httpProvider.defaults.transformRequest.push(spinnerFunction);
		})
		// register the interceptor as a service, intercepts ALL angular ajax
		// http calls
		.factory('myHttpInterceptor', function($q, $window) {
			return function(promise) {
				return promise.then(function(response) {
					// do something on success
					// todo hide the spinner
					$('#loading').hide();
					return response;

				}, function(response) {
					// do something on error
					// todo hide the spinner
					$('#loading').hide();
					return $q.reject(response);
				});
			};
		});
