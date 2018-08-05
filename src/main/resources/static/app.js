var app = angular.module('app.mercadobitcoin', [ 'chart.js' , 'resumeBlock']);

app.controller('dashboardController', function($scope, $http, $q) {

	var mapToPrices = function(value){
		return value.price;
	}
	
	$q.all([	$http.get('/trades/higher_sales'),
				$http.get('/trades/higher_purchases'),
				$http.get('/trades/average_sale'),
				$http.get('/trades/average_purchase'),
				$http.get('/trades/median_sale'),
				$http.get('/trades/median_purchase'),
				$http.get('/trades/default_deviation_sale'),
				$http.get('/trades/default_deviation_purchase')
				
		]).then(function(response) {
			$scope.higher_sales = response[0].data;
			$scope.higher_purchases = response[1].data;
			$scope.average_sale = response[2].data;
			$scope.average_purchase = response[3].data;
			$scope.median_sale = response[4].data;
			$scope.median_purchase = response[5].data;
			$scope.default_deviation_sale = response[6].data;
			$scope.default_deviation_purchase = response[7].data;
			
			$scope.data = [ $scope.higher_sales.map(mapToPrices),
				$scope.higher_purchases.map(mapToPrices) ];
	});

	$scope.labels = [ '1st', '2nd', '3rd', '4th', '5th'];
	$scope.series = [ 'Sale', 'Purchase' ];

	
});