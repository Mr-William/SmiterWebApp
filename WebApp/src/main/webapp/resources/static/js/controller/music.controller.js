angular.module('SmiterApp').controller('MusicController',
	['$scope', 'MusicService', function($scope, MusicService){
		let self = this;
		self.music = {
			id : '',
            songTitle:'',
            albumTitle:'',
            artist:'',
            genre:''
		};

		self.error='';
		self.message='';
		self.reset=reset;
		const bkmodal = document.querySelector(".music-modal");
		const overlay = document.querySelector(".overlay");
		const closeModalBtn = document.querySelector(".btn-close");

		self.musics = [];
			
		const closeModal = function(){
			bkmodal.classList.add("hidden");
			overlay.classList.add("hidden");
		}

		closeModalBtn.addEventListener("click", closeModal);
		overlay.addEventListener("click", closeModal);

		self.getAllMusics = function(){
			MusicService.getAllMusics().then(function(data){
				self.musics = data;
			})
		}
		
		self.createMusic = function(){
			return MusicService.createMusic(self.music).then(function(data){
				window.location.href="/musics";
			})
		}
		
		self.deleteMusic = function(id){
			return MusicService.deleteMusic(id).then(function(){
				self.fetchAllMusics();
			})
		}
		
		self.findMusic = function(music){
			return MusicService.findMusic(music.id).then(function(data){
				self.music = data;
			})
		}

		$scope.submitUpdate = function(){
			console.log("musicId = " + self.music.id);
			console.log("self.musicTitle=" + self.music.musicTitle);
			return MusicService.updateMusic(self.music, self.id).then(function(data){
				closeModal();
				self.getAllMusics();
			})
		}

		$scope.musicDelete = function(){
			console.log(self.music.id);
			if(confirm("Do you really want to delete this music?")){
				return MusicService.deleteMusic(self.music.id).then(function(data){
				closeModal();
				self.getAllMusics();
				})
			}
			else
				return false;
		}

		self.editDetails = function(id){
			bkmodal.classList.remove("hidden");
			overlay.classList.remove("hidden");
			for(const element of self.musics){
				if(element.id === id){
					self.music = angular.copy(element);
					break;
				}
			}
		}

		function reset(){
			self.music={id:null,songTitle:'',albumTitle:'',genre:'',artist:''};
			$scope.musicForm.$setPristine();
		}
		
		function clrMsg(){
		self.error = '';
		self.message = '';
	}

		
		self.getAllMusics();
	}])