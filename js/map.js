function Map(){
    /*this.img=new Image();
    this.img.src="http://7xjda0.com1.z0.glb.clouddn.com/b1.jpg";*/
}
Map.prototype.draw = function(ctx){
    ctx.clearRect(0,0,MAP_WIDTH,MAP_HEIGHT);
    
    ctx.beginPath();
    ctx.lineWidth="4";
    ctx.strokeStyle="green";
    ctx.rect(0,0,MAP_WIDTH,MAP_HEIGHT);
    ctx.stroke();

    ctx.font="30px Verdana";
    // 创建渐变
    var gradient=ctx.createLinearGradient(300,300,500,500);
    gradient.addColorStop("0","magenta");
    gradient.addColorStop("0.5","blue");
    gradient.addColorStop("1.0","red");
    // 用渐变填色
    ctx.fillStyle=gradient;
    ctx.fillText("DuangDuang娘炮游戏区 ",200,350);
    /*ctx.clearRect(0,0,800,800);
    ctx.drawImage(this.img,0,0,800,800);*/

    /*for(var x=0;x<800;x+=10){
        for(var y=0;y<800;y+=10){
            ctx.beginPath();
            ctx.fillStyle="black";
            ctx.arc(x+5,y+5,1,0,2*Math.PI);
            ctx.stroke();
            ctx.fill();
        }
    }*/
}
Map.prototype.drawPath = function(ctx,x,y,pathColor){
    /*ctx.beginPath();
    ctx.fillStyle=pathColor;
    ctx.arc(x,y,2,0,2*Math.PI);
    ctx.stroke();
    ctx.fill();*/
}