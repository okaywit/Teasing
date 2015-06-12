function Map(){}
Map.prototype.draw = function(ctx){
    for(var x=0;x<800;x+=10){
        for(var y=0;y<800;y+=10){
            ctx.beginPath();
            ctx.fillStyle="black";
            ctx.arc(x+5,y+5,2,0,2*Math.PI);
            ctx.stroke();
            ctx.fill();
        }
    }
}
Map.prototype.drawPath = function(ctx,x,y,pathColor){
    /*ctx.beginPath();
    ctx.fillStyle=pathColor;
    ctx.arc(x,y,2,0,2*Math.PI);
    ctx.stroke();
    ctx.fill();*/
}