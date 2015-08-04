'use strict';

/* Controllers */

//将apkmarket.controllers注册到angular
var controllers = angular.module("apkmarket.controllers", []);

controllers.controller('TaskController', ['$scope', '$route','$resource', function TaskController($scope, $route,$resource) {
    $scope.navigator = '推广管理';

    var Item = $resource("/admin/tasks/:id", {id: '@id'}, {
        update: {method: 'PUT',params:{id: null}}
    });

    var Type = $resource("/admin/types/:id", {id: '@id'});

    Type.query(function(response) {
        $scope.types = response ? response : [];
    })

    $scope.editItem = new Item();

    $scope.showItem = true;

    //查询列表
    Item.query(function (response) {
        $scope.items = response ? response : [];
    });

    //编辑
    $scope.EditItem = function (item) {
        $scope.showItem = false;
        $scope.editItem = item;
        var topicType = $scope.types.filter(function (type) {
            return type.id == $scope.editItem.type.id ? true : false;
        })[0];
        //初始化被选中的select option
        $scope.updateSelectedType = topicType;
    }

    //保存或者更新
    $scope.SaveItem = function () {
        if ($scope.editItem.id != null) {
            $scope.editItem.$update(function () {
                $route.reload();
                console.log("更新任务");
            });
        } else {

            $scope.editItem.$save(function () {
                $route.reload();
                console.log("保存任务");
            })
        }

    }

    //新增
    $scope.NewItem = function () {
        $scope.showItem = false;
    }

    //删除
    $scope.DeleteItem = function (index) {
        $scope.items[index].$delete(function (response) {
            if (response.message == "ok") {
                $scope.items.splice(index, 1);
                console.log("删除数据:" + response.message);
            }
        });
    }

    //返回
    $scope.ReloadRoute = function () {
        $route.reload();
    }

    $scope.SelectType = function (updateSelectedType) {
        $scope.updateSelectedType = updateSelectedType;
        $scope.editItem.type = updateSelectedType;

    };


}])

controllers.controller('TaskHistoryController', ['$scope', '$route', '$resource',
    function TaskHistoryController($scope, $route, $resource) {

        $scope.navigator = '推广历史';

        var TaskHistory = $resource("/admin/taskHistories/:id", {id: '@id'});

        TaskHistory.query(function (response) {
            $scope.items = response ? response : [];
        });

        $scope.DeleteItem = function (index) {
            $scope.items[index].$delete(function (response) {
                if (response.message == "ok") {
                    $scope.items.splice(index, 1);
                    console.log("删除数据:" + response.message);
                }
            });
        }
    }]);


