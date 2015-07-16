'use strict';

/* Services */

var services = angular.module('apkmarket.services', ['ngResource']);


services.factory('Task', ['$resource',
    function ($resource) {
        return $resource("/v1/api/tasks/:id", {id: '@id'}, {
            query: {method: 'GET', isArray: true},
            update: {method: 'PUT',params:{id: null}}
        });
    }])

services.factory('TaskHistory', ['$resource',
    function ($resource) {
        return $resource("/v1/api/taskHistories/:id", {id: '@id'}, {
            get: {method: 'GET', isArray: true}
        });
    }])
