angular.module('bfApp.controllers', []).controller('AllDeals',
		function($scope, $route, $location, $routeParams, bfService) {
			$scope.nameFilter = null;
			$scope.dealList = [];
			$scope.displayDealList = [];

			$scope.currentPage = 0;
			$scope.pageSize = 50;
			$scope.storeFilter = null;
			$scope.storeSearchFilter = function(store) {
				var re = new RegExp($scope.storeFilter, 'i');
				return !$scope.storeFilter || re.test(store);
			};

			$scope.searchForResult = function() {
				var searchFor = $scope.dealSearch;
				//$location.path("/home");

				if (searchFor == null || searchFor == "") {
					searchFor = "Walmart";
					$scope.dealSearch = "Walmart";
				}

				$scope.selectedStore = "";
				$scope.selectedCategory = "";

				bfService.searchDeals(searchFor).success(function(response) {
					$scope.dealList = response.deals;
				});
			};

			$scope.categoryFilter = null;

			$scope.categorySearchFilter = function(category) {
				var re = new RegExp($scope.categoryFilter, 'i');
				return !$scope.categoryFilter || re.test(category);
			};

			/*
			 * $scope.searchFilter = function(deal) { var re = new
			 * RegExp($scope.nameFilter, 'i'); var result = (!$scope.nameFilter ||
			 * re.test(deal.item) || re.test(deal.store) ||
			 * re.test(deal.category) || re.test(deal.sub_category) ||
			 * re.test(deal.early_bird) || re.test(deal.rebate) ||
			 * re.test(deal.price));
			 * 
			 * $scope.numberOfPagesByFilter(result);
			 * 
			 * return result; };
			 */

			$scope.numberOfPagesByFilter = function(result) {
				return Math.ceil(result.length / $scope.pageSize);
			};

			var searchFor = $scope.dealSearch;

			if (searchFor == null || searchFor == "") {
				searchFor = "Walmart";
				$scope.dealSearch = "Walmart";
			}

			bfService.searchDeals(searchFor).success(function(response) {
				$scope.dealList = response.deals;
			});

			$scope.numberOfPages = function() {
				return Math.ceil($scope.dealList.length / $scope.pageSize);
			};

			$scope.storeList = [];

			bfService.getStores().success(function(response) {
				$scope.storeList = response.storeNames;
			});

			$scope.categoryList = [];

			bfService.getCategories().success(function(response) {
				$scope.categoryList = response.categoryNames;
			});

			$scope.mobile = false;

			bfService.isMobile().success(function(response) {
				var isMobileDevice = response.replace("\"", "");
				isMobileDevice = isMobileDevice.replace("\"", "");
				if (isMobileDevice === "mobile") {
					$scope.mobile = true;
				} else {
					$scope.mobile = false;
				}
			});
		}).

filter('startFrom', function() {
	return function(input, start) {
		start = +start;
		return input.slice(start);
	}
}).

controller('StoreDeals',
		function($scope, $route, $location, $routeParams, bfService) {
			var category = $routeParams.category;
			var store = $routeParams.store;

			$scope.selectedStore = store;
			$scope.selectedCategory = category;
			$scope.nameFilter = null;
			$scope.storeFilter = null;
			$scope.dealList = [];
			$scope.categoryList = [];

			$scope.storeSearchFilter = function(store) {
				var re = new RegExp($scope.storeFilter, 'i');
				return !$scope.storeFilter || re.test(store);
			};

			$scope.categoryFilter = null;

			$scope.categorySearchFilter = function(category) {
				var re = new RegExp($scope.categoryFilter, 'i');
				return !$scope.categoryFilter || re.test(category);
			};

			/*
			 * $scope.searchFilter = function(deal) { var re = new
			 * RegExp($scope.nameFilter, 'i'); var result = (!$scope.nameFilter ||
			 * re.test(deal.item) || re.test(deal.store) ||
			 * re.test(deal.category) || re.test(deal.sub_category) ||
			 * re.test(deal.early_bird) || re.test(deal.rebate) ||
			 * re.test(deal.price));
			 * 
			 * return result; };
			 */

			$scope.currentPage = 0;
			$scope.pageSize = 50;
			$scope.numberOfPages = function() {
				return Math.ceil($scope.dealList.length / $scope.pageSize);
			};

			$scope.searchForResult = function() {

				var searchFor = $scope.dealSearch;
				//$location.path("/home");

				if (searchFor == null || searchFor == "") {
					searchFor = "Walmart";
					$scope.dealSearch = "Walmart";
				}

				$scope.selectedStore = "";
				$scope.selectedCategory = "";

				bfService.searchDeals(searchFor).success(function(response) {
					$scope.dealList = response.deals;
				});
			};

			bfService.getDealsByStore(store).success(function(response) {
				$scope.dealList = response.deals;
			});

			bfService.getCategoriesByStore(store).success(function(response) {
				if (!angular.isUndefined(store) || store != null) {
					$scope.categoryList = response.storeConfig.categoryConfigs;
				} else {
					$scope.categoryList = response.categoryNames;
				}
			});

			bfService.getStoresByCategory(category).success(function(response) {
				if (!angular.isUndefined(category) || category != null) {
					$scope.storeList = response.storeList.storeNames;
				} else {
					$scope.storeList = response.storeNames;
				}
			});

			$scope.mobile = false;

			bfService.isMobile().success(function(response) {
				var isMobileDevice = response.replace("\"", "");
				isMobileDevice = isMobileDevice.replace("\"", "");
				if (isMobileDevice === "mobile") {
					$scope.mobile = true;
				} else {
					$scope.mobile = false;
				}
			});
		}).

controller(
		'CategoryDeals',
		function($scope, $route, $location, $routeParams, bfService) {
			var category = $routeParams.category;
			var store = $routeParams.store;

			$scope.nameFilter = null;
			$scope.selectedStore = store;
			$scope.selectedCategory = category;
			$scope.dealList = [];
			$scope.storeList = [];
			$scope.storeFilter = null;

			$scope.storeSearchFilter = function(store) {
				var re = new RegExp($scope.storeFilter, 'i');
				return !$scope.storeFilter || re.test(store);
			};

			$scope.categoryFilter = null;

			$scope.categorySearchFilter = function(category) {
				var re = new RegExp($scope.categoryFilter, 'i');
				return !$scope.categoryFilter || re.test(category);
			};

			/*
			 * $scope.searchFilter = function(deal) { var re = new
			 * RegExp($scope.nameFilter, 'i'); var result = (!$scope.nameFilter ||
			 * re.test(deal.item) || re.test(deal.store) ||
			 * re.test(deal.category) || re.test(deal.sub_category) ||
			 * re.test(deal.early_bird) || re.test(deal.rebate) ||
			 * re.test(deal.price)); return result; };
			 */

			$scope.searchForResult = function() {

				var searchFor = $scope.dealSearch;
				//$location.path("/home");

				if (searchFor == null || searchFor == "") {
					searchFor = "Walmart";
					$scope.dealSearch = "Walmart";
				}

				$scope.selectedStore = "";
				$scope.selectedCategory = "";

				bfService.searchDeals(searchFor).success(function(response) {
					$scope.dealList = response.deals;
				});
			};

			bfService.getDealsByCategory(category, store).success(
					function(response) {
						$scope.dealList = response.deals;
					});

			bfService.getStoresByCategory(category).success(function(response) {
				if (!angular.isUndefined(category) || category != null) {
					$scope.storeList = response.storeList.storeNames;
				} else {
					$scope.storeList = response.storeNames;
				}
			});

			bfService.getCategoriesByStore(store).success(function(response) {
				if (!angular.isUndefined(store) || store != null) {
					$scope.categoryList = response.storeConfig.categoryConfigs;
				} else {
					$scope.categoryList = response.categoryNames;
				}
			});

			$scope.currentPage = 0;
			$scope.pageSize = 50;
			$scope.numberOfPages = function() {
				return Math.ceil($scope.dealList.length / $scope.pageSize);
			};

			$scope.mobile = false;

			bfService.isMobile().success(function(response) {
				var isMobileDevice = response.replace("\"", "");
				isMobileDevice = isMobileDevice.replace("\"", "");
				if (isMobileDevice === "mobile") {
					$scope.mobile = true;
				} else {
					$scope.mobile = false;
				}
			});
		}).

controller(
		'StoreCategoryDeals',
		function($scope, $route, $location, $routeParams, bfService) {
			var category = $routeParams.category;
			var store = $routeParams.store;

			$scope.nameFilter = null;
			$scope.selectedStore = store;
			$scope.selectedCategory = category;
			$scope.dealList = [];
			$scope.storeFilter = null;

			$scope.storeSearchFilter = function(store) {
				var re = new RegExp($scope.storeFilter, 'i');
				return !$scope.storeFilter || re.test(store);
			};

			$scope.categoryFilter = null;

			$scope.categorySearchFilter = function(category) {
				var re = new RegExp($scope.categoryFilter, 'i');
				return !$scope.categoryFilter || re.test(category);
			};

			/*
			 * $scope.searchFilter = function(deal) { var re = new
			 * RegExp($scope.nameFilter, 'i'); var result = (!$scope.nameFilter ||
			 * re.test(deal.item) || re.test(deal.store) ||
			 * re.test(deal.category) || re.test(deal.sub_category) ||
			 * re.test(deal.early_bird) || re.test(deal.rebate) ||
			 * re.test(deal.price)); return result; };
			 */

			$scope.searchForResult = function() {

				var searchFor = $scope.dealSearch;
				//$location.path("/home");

				if (searchFor == null || searchFor == "") {
					searchFor = "Walmart";
					$scope.dealSearch = "Walmart";
				}

				$scope.selectedStore = "";
				$scope.selectedCategory = "";

				bfService.searchDeals(searchFor).success(function(response) {
					$scope.dealList = response.deals;
				});
			};

			bfService.getDealsByStoreCategory(store, category).success(
					function(response) {
						$scope.dealList = response.dealList.deals;
					});

			bfService.getStoresByCategory(category).success(function(response) {
				if (!angular.isUndefined(category) || category != null) {
					$scope.storeList = response.storeList.storeNames;
				} else {
					$scope.storeList = response.storeNames;
				}
			});

			bfService.getCategoriesByStore(store).success(function(response) {
				if (!angular.isUndefined(store) || store != null) {
					$scope.categoryList = response.storeConfig.categoryConfigs;
				} else {
					$scope.categoryList = response.categoryNames;
				}
			});

			$scope.currentPage = 0;
			$scope.pageSize = 50;
			$scope.numberOfPages = function() {
				return Math.ceil($scope.dealList.length / $scope.pageSize);
			};

			$scope.mobile = false;

			bfService.isMobile().success(function(response) {
				var isMobileDevice = response.replace("\"", "");
				isMobileDevice = isMobileDevice.replace("\"", "");
				if (isMobileDevice === "mobile") {
					$scope.mobile = true;
				} else {
					$scope.mobile = false;
				}
			});
		});
