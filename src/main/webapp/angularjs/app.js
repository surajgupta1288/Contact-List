var app = angular.module('AngularProject', []);

app.controller('ContactViewController', function($scope,$http){
$http({

method: 'GET',

url: 'http://localhost:8082/contact'

}).then(function success(response) {

$scope.Contact = response.data;
}, function error(response) {

});
$scope.deleteContact = function(id) {

    //$http DELETE function
    $http({
      url: 'http://localhost:8082/deletecontact/' + id,
      method: 'DELETE',

    }).then(function successCallback(response) {

      alert("Contact has deleted Successfully");
      var index = $scope.Contact.indexOf(contact.id);
      $scope.Contact.splice(index, 1);

    }, function errorCallback(response) {

      alert("Error. while deleting user Try Again!");

    });

  };
  $scope.editContact = function(contact) {

    $http({
      url: 'http://localhost:8082/contact/' + contact.id,
      method: 'GET',

    }).then(function successCallback(response) {
var index = $scope.Contact.indexOf(contact);
sessionStorage.setItem("Contact" ,JSON.stringify(response.data));
location.replace("../update.html");
    }, function errorCallback(response) {

    });
  };
});

app.controller('UpdateContactController', function ($scope, $http, $log, $location) {
	string=sessionStorage.getItem("Contact");
		var obj =JSON.parse(string);
		$scope.id = obj.id;
		$scope.name = obj.name;
		$scope.phone = obj.phone;
 $scope.updateContact = function () {
const data={
	"id": $scope.id,
    "name": $scope.name,
    "phone": $scope.phone
}
    $http({
      url: "http://localhost:8082/contact",data ,
      method: "PUT"
    }).then(function (response) {   
	alert("Successfully Updated Contact!!!");	
		location.replace("../index.html");
}, function error(response) {
      $scope.error = 'Invalid credentials!!!';
    });
  };
});
app.controller('AddContactController', function ($scope, $http, $log, $location) {



  $scope.addContact = function () {
const data={
    "name": $scope.name,
    "phone": $scope.phone
}
    $http({
      url: "http://localhost:8082/contact",data ,
      method: "POST"
    }).then(function (response) {   
	alert("Successfully Registerd Contact!!!");
	location.replace("../index.html");	
}, function error(response) {
      $scope.error = 'Invalid credentials!!!';
    });
  };
});

