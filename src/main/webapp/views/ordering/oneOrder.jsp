<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ярослав
  Date: 11.08.2016
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="templatemo_wrapper1" style="height: 300%; overflow: auto">
    <c:forEach items="${order}" var="a">


        <div style="font-size: 20px; text-align: center; width: 99%; height: auto; background-color: gainsboro; color: #101010; float: left;margin-top: 15px;  border: 5px double black; border-radius: 0px;">


            <p style="font-size: 20px;">${a.customer}</p>

            <p>Вітаємо Вас...Замовлення здійснено! Скоро з Вами зв'яжуться наші продавці. </p>

            <p style="font-size: 20px;">${a.purseList}</p>
            <p style="font-size: 20px;"> Дата ${a.date}</p>
            <p style="font-size: 20px;">Сума ${a.sum} грн.</p>


        </div>


    </c:forEach>
</div>

