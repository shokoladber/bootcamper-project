'use strict';

angular.module('MGL_Task1_app').factory('MGL_Task1_Service', ['$http', function($http) {

		var REST_SERVICE_URI = 'games';

		var factory = {
			fetchAllGames : fetchAllGames,
			saveGame : saveGame,
			deleteGame : deleteGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + "Library").then(function(response) {
					return response.data;
				}
			);
		}

		function saveGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}

		function deleteGame(id) {
		    return $http.post(REST_SERVICE_URI + "/" + id + "/delete").then(function(response) {
                    return response.data;
                }
            );
		}

}]);
