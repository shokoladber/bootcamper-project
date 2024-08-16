'use strict';

angular.module('MGL_Task1_app').controller('MGL_Task1_Controller',
		[ 'MGL_Task1_Service', function(MGL_Task1_Service) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};

			self.games = [];
			const form = document.getElementById("gameForm");
			const gameName = document.getElementById("name");
			const gameGenre = document.getElementById("genre");
			const gameId = document.getElementById("gameId");

			self.fetchAllGames = function(){
				MGL_Task1_Service.fetchAllGames().then(function(data) {
				    self.games = data;
				});
			}

			self.saveGame = function(){
				return MGL_Task1_Service.saveGame(self.game).then( function() {
				    form.reset();
                    self.fetchAllGames();
				});
			}

			self.deleteGame = function(game){
			    return MGL_Task1_Service.deleteGame(game.id).then( function(){
			        form.reset();
			        self.fetchAllGames();
			    })
			}

			self.selectGame = function(game){
			    gameName.value=game.name;
			    gameGenre.value=game.genre;
			    gameId.value=game.id;
			}

			self.fetchAllGames();
		} ]);
