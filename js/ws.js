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
    Server.connect("ws://grownbook.com:8080/game");
};
Server.init();