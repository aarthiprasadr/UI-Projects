angular.module('bfApp.controllers', []).

controller('addDeals', function($scope, bfService) {
	$scope.deals = [];

	$scope.addDeal = function() {
		var deal = {
			"store" : $scope.store,
			"category" : $scope.category,
			"sub_category" : $scope.subcategory,
			"item" : $scope.item,
			"early_bird" : $scope.earlybird,
			"rebate" : $scope.rebate,
			"img_url" : $scope.imgurl,
			"product_url" : $scope.producturl,
			"price" : $scope.price
		};

		$scope.deals.push(deal);

		bfService.addDeal(deal).success(function(response) {
			alert("successfully added!");
		});

	};

	$scope.removeDeal = function(index) {
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

controller(
		'editDeals',
		function($scope, bfService) {
			$scope.deals = [];

			$scope.nameFilter = null;
			$scope.dealList = [];

			$scope.currentPage = 0;
			$scope.pageSize = 50;
			$scope.storeFilter = null;

			$scope.searchFilter = function(deal) {
				var re = new RegExp($scope.nameFilter, 'i');
				var result = (!$scope.nameFilter || re.test(deal.item)
						|| re.test(deal.store)
						|| re.test(deal.category)
						|| re.test(deal.sub_category)
						|| re.test(deal.early_bird)
						|| re.test(deal.rebate)
						|| re.test(deal.img_url)
						|| re.test(deal.product_url) || re.test(deal.price));

				return result;
			};

			bfService.getDeals().success(function(response) {
				$scope.dealList = response.deals;
			});

			$scope.numberOfPages = function() {
				return Math.ceil($scope.dealList.length
						/ $scope.pageSize);
			};

			$scope.addDeal = function(deal) {
				/*var deal = {
					"id" : $scope.dealList[key].id,
					"store" : $scope.dealList[key].store,
					"category" : $scope.dealList[key].category,
					"sub_category" : $scope.dealList[key].sub_category,
					"item" : $scope.dealList[key].item,
					"early_bird" : $scope.dealList[key].early_bird,
					"rebate" : $scope.dealList[key].rebate,
					"img_url" : $scope.dealList[key].img_url,
					"product_url" : $scope.dealList[key].product_url,
					"price" : $scope.dealList[key].price
				};*/

				bfService.addDeal(deal).success(function(response) {
					alert("successfully updated!");
				});
			};
		}).

filter('startFrom', function() {
	return function(input, start) {
		start = +start; // parse to int
		return input.slice(start);
	}
});

