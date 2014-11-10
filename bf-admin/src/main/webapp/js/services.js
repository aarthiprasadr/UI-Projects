/**
 * Notification Service Module
 */
angular.module('bfApp.services', []).factory(
		'bfService',
		function($http) {

			var bfAPI = {};
			
			bfAPI.addDeal = function($deal) {
			  return $http({
			        method: 'POST',
			        headers: { 'content-type': 'application/json' },
				    data: $deal,
				    url: 'http://104.130.240.61:8080/bf-ws/addDeal'
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

			return bfAPI;
		});