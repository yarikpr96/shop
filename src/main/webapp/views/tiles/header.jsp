<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ярослав
  Date: 31.08.2016
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/resources1/style.css" type="text/css"/>
<script type="text/javascript" src="/resources/resources1/script.js"></script>
<link href="/resources/resources1/templatemo_style.css" rel="stylesheet" type="text/css">

<div id="templatemo_wrapper1">

    <body>
    <div id="templatemo_header">

        <div id="site_title"><h1><a href="/"></a></h1></div>

        <div id="twitter"><a href="#"></a></div>

        <div>
            <sec:authorize access="isAnonymous()">
                <a style="
        float: right;
	    width: 80px;
	    border-left: 10px solid #444443;
	    padding-left: 15px;
	    line-height: 30px;


    " href="/loginpage">
                    <button style="font-size: 12pt" type="submit">Увійти</button>
                </a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <form:form method="post" action="/logout">
                    <button type="submit"
                            style="
            float: right;
	        width: 80px;
	        border-left: 1px solid #444443;
	        padding-left: 15px;
	        /*line-height: 30px;*/
            font-size: 12pt

    ">Вийти
                    </button>
                </form:form>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <a style="
            float: right;
	        width: 80px;
	        border-left: 0px solid #444443;
	        /*padding-left: 30px;*/
	        line-height: 30px;


            " href="/registration">
                    <button style="font-size: 12pt" type="submit">Реєстрація</button>
                </a>
            </sec:authorize>
        </div>
        <div id="templatemo_menu">


            <%@ page contentType="text/html;charset=UTF-8" language="java" %>


            <div style="height: 100%">

                <ul class="menu" id="menu">
                    <li><a href="/" class="menulink">Головна</a></li>
                    <sec:authorize access="hasRole('USER')">
                        <li><a href="/cabinet" class="menulink">Ваш кабінет</a></li>
                    </sec:authorize>
                    <li><a href="/ourWork" class="menulink">Наші роботи</a></li>

                    <li><a href="/allPurse" class="menulink">Магазин</a>
                        <ul>
                            <sec:authorize access="hasRole('ADMIN')">
                                <li><a href="/newPurse">Додати товар</a></li>
                            </sec:authorize>
                                <%--<li><a href="#">Navigation Item 2</a></li>--%>

                        </ul>

                    </li>

                    <sec:authorize access="hasRole('USER')">
                        <li><a href="/purse" class="menulink">Замовлення</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <li><a href="/about" class="menulink">Про нас</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <li><a href="/allOrder" class="menulink">Всі замовлення</a></li>
                    </sec:authorize>

                </ul>

                <script type="text/javascript">
                    var menu = new menu.dd("menu");
                    menu.init("menu", "menuhover");
                </script>


            </div>


        </div> <!-- end of templatemo_menu -->

    </div>
</div>
</body>