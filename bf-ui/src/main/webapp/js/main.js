angular.module('bfApp', [
   'bfApp.services',
   'bfApp.controllers',
   'ngRoute'
 ]).
 config(['$routeProvider', function($routeProvider) {
   $routeProvider.
   	when("/category/:category/store/:store", {templateUrl: "partials/Deals.html", controller: "StoreCategoryDeals"}).
   	when("/store/:store/category/:category", {templateUrl: "partials/Deals.html", controller: "StoreCategoryDeals"}).
   	when("/store/:store", {templateUrl: "partials/Deals.html", controller: "StoreDeals"}).
   	when("/category/:category", {templateUrl: "partials/Deals.html", controller: "CategoryDeals"}). 	
   	when("/home", {templateUrl: "partials/Deals.html", controller: "AllDeals"}).
   	otherwise({redirectTo: '/home'});
 }]);