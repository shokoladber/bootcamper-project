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
			const addButton = document.getElementById("add");
			const updateButton = document.getElementById("update");
			const buttons = document.getElementById("buttons");

			self.fetchAllGames = function(){
				MGL_Task1_Service.fetchAllGames().then(function(data) {
				    self.games = data;
				});
			}

			self.addGame = function(){
				return MGL_Task1_Service.createGame(self.game).then( function() {
                    self.fetchAllGames();
				    form.reset();
				});
			}

			self.deleteGame = function(game){
			    return MGL_Task1_Service.deleteGame(game.id).then( function(){
			        self.fetchAllGames();
			        form.reset();
			    })
			}

			self.selectGame = function(game){
			    console.log(buttons);
			    gameName.value=game.name;
			    gameGenre.value=game.genre;
			    gameId.value=game.id;

			}

			self.fetchAllGames();
		} ]);
