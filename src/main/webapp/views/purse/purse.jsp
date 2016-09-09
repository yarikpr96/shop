<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div id="templatemo_wrapper1" style="height: 100%;overflow: auto;">

        <h1 style="text-align: center;float: inherit">Замовлення</h1>

        <div>
            <c:forEach items="${purses}" var="a">

                <div style="font-size: 18px;  width: 99%; height: 20; background-color: white; color: #101010;   border: 2px double black; border-radius: 0px;">
                    <form:form action="/pursedell/${a.id_p}" method="post">
                        <a style="font-size: 20px;color: #101010;">${a.name} - ${a.price} грн.
                            <button style="float: right" type="submit">Видалити</button>
                        </a>
                    </form:form>
                </div>

            </c:forEach>
            <c:forEach items="${myPurses}" var="a">

                <div style="font-size: 18px;  width: 99%; height: 20; background-color: white; color: #101010;   border: 2px double black; border-radius: 0px;">
                    <form:form action="/#/${a.id_p}" method="post">
                        <a style="font-size: 20px;color: #101010;">${a.name} - ${a.price} грн.
                            <button style="float: right" type="submit">Видалити</button>
                        </a>
                    </form:form>
                </div>

            </c:forEach>
        </div>
        <div style="font-size: 20px; text-align: center; width: 99%; height: auto; background-color: lightgreen; color: #101010; float: left;  border: 2px double black; border-radius: 0px;">
            <p>Сума замовлення ${price} грн.</p>
            <form:form action="/data" method="post">
                <button type="submit">Замовити</button>
            </form:form>
            <form:form action="/pursedel" method="post">
                <button type="submit"> Очистити список</button>
            </form:form>
        </div>
    </div>
<%--</div>--%>
