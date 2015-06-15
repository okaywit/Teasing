function Bomb(player){
    this.speed = 10;
    this.player = player;
    this.bx = player.x;
    this.by = player.y;
    this.taskId = 0;
    this.direction = player.direction;
    this.shootTime = new Date().getTime();
    this.ctx;
    
    /*if(this.direction == 37)
        this.bx = parseInt(this.bx)-10;
    if(this.direction == 38)
        this.by = parseInt(this.by)-10;
    if(this.direction == 39)
        this.bx = parseInt(this.bx)+10;
    if(this.direction == 40)
        this.by = parseInt(this.by)+10;*/

}
Bomb.prototype.check=function(){
    for(id in Game.players){
        if(Game.players[id] != null && Game.players[id].x == this.bx &&  Game.players[id].y == this.by){
            Server.socket.send(packMsg(4,this.player.id,this.bx,this.by,4,'attack',Game.players[id].direction));
            this.player.isAttack = 0;
            clearInterval(this.taskId);
        }
    }
}
Bomb.prototype.draw=function(){
    this.ctx.fillStyle = 'black';
    //this.ctx.clearRect(parseInt(this.bx)-3,parseInt(this.by)-3,6,6);
    
    if ((this.bx > 0 && this.bx<=795) && (this.by>0 && this.by<=795)){
        
        var runTime = new Date().getTime()-this.shootTime;

        if(this.direction == 37){
            this.bx = parseInt(this.bx)-this.speed;
        }
        if(this.direction == 38){
            this.by = parseInt(this.by)-this.speed;
        }
        if(this.direction == 39){
            this.bx = parseInt(this.bx)+this.speed;
        }
        if(this.direction == 40){
            this.by = parseInt(this.by)+this.speed;
        }

        for(id in Game.players){
            if(Game.players[id] != null && Game.players[id].x == this.bx &&  Game.players[id].y == this.by){
                Server.socket.send(packMsg(4,this.player.id,this.bx,this.by,4,'attack',Game.players[id].direction));
                this.player.isAttack = 0;
                clearInterval(this.taskId);
                return;
            }
        }

        this.ctx.beginPath();
        this.ctx.arc(this.bx,this.by,2,0,2*Math.PI);
        this.ctx.stroke();
        this.ctx.fill();
    }else{
        this.player.isAttack = 0;
        clearInterval(this.taskId);
    }
    //Server.socket.send(packMsg(4,this.player.id,this.bx,this.by,3,'attack',this.direction));
    //this.player.isAttack = 0;
    
}

