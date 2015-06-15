var Server = {};
Server.socket = null;
Server.connect=(function(host){
	Server.socket = new WebSocket(host);
	Server.socket.onopen = function(){
		
	};
	Server.socket.onmessage = function(message){
		gameMsg(message);
	};
	Server.socket.onerror = function(error){

	};
	Server.socket.onclose = function(){
		
	};
});

Server.init=function(){
    Server.connect("ws://localhost:8080/okaywit/game");
};
Server.init();