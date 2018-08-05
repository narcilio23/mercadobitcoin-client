angular.module('resumeBlock', [])

.directive('resumeBlock', function(){
	return {
		restrict: 'E',
		scope: {
			'title' : '@',
			'saleValue': '@',
			'purchaseValue': '@'
		},
		templateUrl: 'component/resume-block.html',
		link: function(scope, elem, attrs){
		}
	}
})