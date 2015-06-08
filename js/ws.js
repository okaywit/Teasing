var Server = {};
Server.socket = null;
Server.connect=(function(host){
	Server.socket = new WebSocket(host);
	Server.socket.onopen = function(){

	};
	Server.socket.onmessage = function(message){
		
	};
	Server.socket.onerror = function(error){

	};
	Server.socket.onclose = function(){

	};
});