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
<form method="POST" action="${pageContext.request.contextPath}/createmodel">
    <div id="descr">
    <p> Данная программа позволяет произвести моделирование работы кассового обслуживания  в магазине.
        Пожалуйста введите первоначальные параметры и нажмите кнопку "Запуск моделирования ...".
        После завершения процесса построения Модели Вы будете перенаправлены на страницу
        пошагового просмотра результатов.
    </p>
    </div>
    <br>
    <br>
    <div id="inpval">

    <p><strong>Количество шагов работы магазина (2-30):</strong>
    <input type="text" required size="4" maxlength="2" min="2" max="30" placeholder="25" pattern="[0-9]{1,2}" name="numStep"/>

    <p><strong>Число касс (1-4):</strong>
    <input type="text" required size="4" maxlength="1" placeholder="2" pattern="[0-9]{1}" name="numCashBox"/>
    <br>

    <p><strong>Производительность кассы (2-5):</strong>
    <input type="text" required size="4" maxlength="1" placeholder="5" pattern="[0-9]{1}" name="powerCashBox"/>
    <br>
    </div>

    <p>    
        <button type="submit" name="saveDraft">Запуск моделирования ...</button>
    </p>    
</form>



    </body>
</html>