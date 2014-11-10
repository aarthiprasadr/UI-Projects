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
	});