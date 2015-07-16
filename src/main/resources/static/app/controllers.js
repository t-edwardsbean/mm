'use strict';

/* Controllers */

//将apkmarket.controllers注册到angular
var controllers = angular.module("apkmarket.controllers", []);

controllers.controller('TaskController', ['$scope', '$route', 'Task', function TaskController($scope, $route, Task) {
    $scope.navigator = '推广管理';

    $scope.editTask = new Task();

    Task.query(function (response) {
        $scope.tasks = response ? response : [];
    });

    $scope.showTask = true;

    $scope.EditTask = function (task) {
        $scope.showTask = false;
        $scope.editTask = task;
    }
    $scope.SaveTask = function () {
        if ($scope.editTask.id != null) {
            $scope.editTask.$update(function () {
                $route.reload();
                console.log("更新任务");
            });
        } else {

            $scope.editTask.$save(function () {
                $route.reload();
                console.log("保存任务");
            })
        }

    }

    $scope.NewTask = function () {
        $scope.showTask = false;
    }

    $scope.ReloadRoute = function () {
        $route.reload();
    }

    $scope.DeleteTask = function (index) {
        $scope.tasks[index].$delete(function (response) {
            if (response.message == "ok") {
                $scope.tasks.splice(index, 1);
                console.log("删除数据:" + response.message);
            }
        });

    }

}])

controllers.controller('TaskHistoryController', ['$scope', '$route', 'TaskHistory',
    function TaskHistoryController($scope, $route, TaskHistory) {

        $scope.navigator = '推广历史';

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


