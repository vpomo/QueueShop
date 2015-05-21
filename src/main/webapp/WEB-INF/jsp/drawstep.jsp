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

            <div id="descr">
                <span>Расчет модели работы магазина закончен.
                Теперь можно просмотреть результаты по шагам.
                Пожалуйста, нажмите кнопку для продолжения</span> 
            </div>

<br>
<br>

<form method="POST" action="${pageContext.request.contextPath}/drawqueue">
<p>
	<input type="button" value="Вернуться назад ..." onClick="history.go(-1)">
        <button type="submit" name="retStepNext">Продолжить работу ...</button>
    </p>    

</form>

    </body>
</html>