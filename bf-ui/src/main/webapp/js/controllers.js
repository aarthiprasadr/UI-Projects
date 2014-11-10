angular.module('bfApp.controllers', []).

controller('addDeals', function($scope, bfService) {
	  $scope.deals = [];
	    
	  $scope.addDeal = function(){
	    var deal = {
	        "store": $scope.store,
	        "category": $scope.category,
	        "sub_category": $scope.subcategory,
	        "item": $scope.item,
	        "early_bird": $scope.earlybird,
	        "rebate": $scope.rebate,
	        "img_url": $scope.imgurl,
	        "product_url": $scope.producturl,
	        "price": $scope.price
	    };
	    
	    $scope.deals.push(deal);
	    
	    bfService.addDeal(deal).success(function (response) {
	    	alert("successfully added!");
	    });
	    
	  };
	   
	   $scope.removeDeal = function(index){
	    $scope.deals.splice(index, 1);
	   };    
	   
	   $scope.storeList = [];
		bfService.getStores().success(function(response) {
			$scope.storeList = response.storeNames;
		});

		$scope.categoryList = [];
		bfService.getCategories().success(function(response) {
			$scope.categoryList = response.categoryNames;
		});
		
		$scope.subcategoryList = [];
		bfService.getSubCategories().success(function(response) {
			$scope.subcategoryList = response.subCategoryNames;
		});
	}).

controller('AllDeals', function($scope, bfService) {
	$scope.nameFilter = null;
	$scope.dealList = [];

	$scope.searchFilter = function(deal) {
		var re = new RegExp($scope.nameFilter, 'i');
		return !$scope.nameFilter || re.test(deal.item);
	};

	bfService.getDeals().success(function(response) {
		$scope.dealList = response.deals;
	});

	$scope.storeList = [];

	bfService.getStores().success(function(response) {
		$scope.storeList = response.storeNames;
	});

	$scope.categoryList = [];

	bfService.getCategories().success(function(response) {
		$scope.categoryList = response.categoryNames;
	});
}).

controller('StoreDeals',
		function($scope, $route, $location, $routeParams, bfService) {
			var category = $routeParams.category;
			var store = $routeParams.store;
			$scope.selectedStore = store;
			$scope.selectedCategory = category;
			$scope.nameFilter = null;
			$scope.dealList = [];
			$scope.categoryList = [];

			$scope.searchFilter = function(deal) {
				var re = new RegExp($scope.nameFilter, 'i');
				return !$scope.nameFilter || re.test(deal.item) || re.test(deal.store) || re.test(deal.category) || re.test(deal.early_bird) || re.test(deal.rebate) || re.test(deal.price);
			};

			bfService.getDealsByStore(store).success(function(response) {
				$scope.dealList = response.deals;
			});

			bfService.getCategoriesByStore(store).success(function(response) {
				$scope.categoryList = response.storeConfig.categoryConfigs;
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
			
			$scope.searchFilter = function(deal) {
				var re = new RegExp($scope.nameFilter, 'i');
				return !$scope.nameFilter || re.test(deal.item) || re.test(deal.store) || re.test(deal.category) || re.test(deal.early_bird) || re.test(deal.rebate) || re.test(deal.price);
			};

			bfService.getDealsByCategory(category, store).success(
				function(response) {
					$scope.dealList = response.deals;
			});
						
			bfService.getStoresByCategory(category).success(function(response) {
				$scope.storeList = response.storeList.storeNames;
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

			$scope.searchFilter = function(deal) {
				var re = new RegExp($scope.nameFilter, 'i');
				return !$scope.nameFilter || re.test(deal.item) || re.test(deal.store) || re.test(deal.category) || re.test(deal.early_bird) || re.test(deal.rebate) || re.test(deal.price);
			};

			bfService.getDealsByStoreCategory(store, category).success(
				function(response) {
					$scope.dealList = response.dealList.deals;
				});
		});