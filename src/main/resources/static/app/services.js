'use strict';

/* Services */

var services = angular.module('apkmarket.services', ['ngResource']);


services.factory('Task', ['$resource',
    function ($resource) {
        return $resource("/admin/tasks/:id", {id: '@id'}, {
            update: {method: 'PUT',params:{id: null}}
        });
    }])

services.factory('TaskHistory', ['$resource',
    function ($resource) {
        return $resource("/admin/taskHistories/:id", {id: '@id'}, {
        });
    }])
