<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
        
    </head>
    <body>
        <header>
            <div id="logo">
                <h1>Моделирование работы магазина</h1>
            </div>
        </header>

<br>
<br>

            <div id="notif">
                <span>${notif}</span> 
            </div>

<br>
<br>

<form>
	<input type="button" value="Вернуться назад ..." onClick="history.go(-1)">
</form>

    </body>
</html>