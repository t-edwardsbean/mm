'use strict';

/* App Module */

var apkmarket = angular.module('apkmarket', [
    'ngRoute',
    'ngResource',
    'apkmarket.controllers'
]);

apkmarket.config(['$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'task.html',
                controller: 'TaskController'
            }).when('/task-history', {
                templateUrl: 'task-history.html',
                controller: 'TaskHistoryController'
            });

        $locationProvider.html5Mode(false).hashPrefix('!');
    }]);



