angular.module('bfApp', [ 'bfApp.services', 'bfApp.controllers', 'ngRoute' ])
		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when("/addDeal", {
				templateUrl : "partials/addDeals.html",
				controller : "addDeals"
			}).when("/editDeal", {
				templateUrl : "partials/editDeals.html",
				controller : "editDeals"
			}).otherwise({
				redirectTo : '/addDeal'
			});
		} ])
