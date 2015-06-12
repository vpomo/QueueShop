<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Отрисовка очередей в магазине</title>
    </head>

    <body>
        <p> Шаг № 1</p>
        
<img id="image1" alt="Касса №1" src="${pageContext.request.contextPath}/resources/image/kassa.jpg" style="display:none;"/>
<img id="image2" alt="man" src="${pageContext.request.contextPath}/resources/image/man.png" style="display:none;"/>
<img id="image3" alt="woman" src="${pageContext.request.contextPath}/resources/image/woman.png" style="display:none;"/>
<img id="image4" alt="child" src="${pageContext.request.contextPath}/resources/image/child.png" style="display:none;"/>

<canvas id='draw' width='500' height='400' style='border:1px solid;'></canvas> 


<script type='text/javascript'>
var imgkassa=document.getElementById("image1");
var imgman=document.getElementById("image2");
var imgwoman=document.getElementById("image3");
var imgchild=document.getElementById("image4");


var canvas=document.getElementById("draw");
var x=canvas.getContext("2d");
x.font='10px Verdana';
x.fillStyle='#60016d';


x.drawImage(imgman,80,40);
x.drawImage(imgkassa,10,40);
x.fillStyle='#60016d';
x.fillText("Касса №1", 10, 40);

x.drawImage(imgwoman,80,130);
x.drawImage(imgkassa,10,130);
x.fillStyle='#60016d';
x.fillText("Касса №2", 10, 130);

x.drawImage(imgchild,80,220);
x.drawImage(imgkassa,10,220);
x.fillStyle='#60016d';
x.fillText("Касса №3", 10, 220);

x.drawImage(imgwoman,80,310);
x.drawImage(imgkassa,10,310);
x.fillStyle='#60016d';
x.fillText("Касса №4", 10, 310);
</script>



    </body>
</html>
