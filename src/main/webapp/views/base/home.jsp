<%--
  Created by IntelliJ IDEA.
  User: Ярослав
  Date: 31.08.2016
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/resources/templatemo_style.css" rel="stylesheet" type="text/css">

<div id="templatemo_wrapper1">
    <div id="templatemo_main">
        <div class="col_w960">

            <div class="col_w450 float_l">
               <p style="font-size: 16px; color: white">Гаманець винайшли з появою грошей. Раніше гаманці мала тільки знать. Гаманець мав форму шкіряного мішка, який стягувався шнурами. У таких гаманцях зручно було переносити гроші тих часів золоті та срібні монети. Зі зміною форми готівки, змінювалися призначення та форма гаманців. До сучасного гаманцю висувається безліч вимог. Хтось хоче купити гаманець з великою кількістю розділів, які повинні розміщувати готівку, не згинаючи купюр, а також мати велику кількість розділів для кредитних карт. А хтось зовсім навпаки шукає невеликий гаманець, який непомітний у кишені, але розміщує мінімум необхідних коштів і кредитних карт. Наш інтернет магазин гаманці пропонує в широкому асортименті. На сторінках каталогу нашого інтернет магазину ви знайдете жіночі гаманці, портмоне, чоловічий гаманець, ключниці, візитівки й інші товари на самий незвичайний і вишуканий смак.</p>
                <%--<a class="more" href="#">More</a>--%>
            </div>

            <div class="col_w450 float_r">
                <h2>Наші роботи</h2>
                <ul class="lp_frontpage">
                    <li><a href="#"><img width="200" height="100" src="/resources/resources1/images/templatemo_image_01.jpg" alt="Image 01"></a></li>
                    <li><a href="#"><img width="200" height="100" src="/resources/resources1/images/templatemo_image_02.jpg" alt="Image 02"></a></li>
                    <li><a href="#"><img width="200" height="100" src="/resources/resources1/images/templatemo_image_03.jpg" alt="image 03"></a></li>
                    <li><a href="#"><img width="200" height="100" src="/resources/resources1/images/templatemo_image_04.jpg" alt="image 04"></a></li>
                </ul>

                <div class="cleaner"></div>
                <a class="more" href="/ourWork">More</a>
            </div>

            <div class="cleaner"></div>
        </div>

        <div class="col_w960 col_last">
            <div class="col_allw300 frontpage_box">
                <h2>Про нас<span> </span></h2>
                <p>Якщо у Вас виникли питання звертайтеся</p>
                <a class="more" href="/about">More</a>
            </div>

            <div class="col_allw300 frontpage_box">
                <h2>Доставка<span> </span></h2>
                <p>Доставка по всій території України </p>
                <a class="more" href="#">More</a>
            </div>

            <div class="col_allw300 frontpage_box col_last">
                <h2>Нові колекції<span></span></h2>
                <p>Нові товари </p>
                <a class="more" href="#">More</a>
            </div>

            <div class="cleaner"></div>
        </div>


        <style type="text/css">
            /** {*/
            /*box-sizing: border-box;*/
            /*}*/
            /*body {*/
            /*background: #00796B;*/
            /*margin: 0;*/
            /*font:14px/1.3 'Roboto',Helvetica,sans-serif;*/
            /*}*/
            h1,
            h2 {
                font-weight: 300;
                margin: 0 0 1rem 0;
            }
            a {
                text-decoration: none;
                color: #72dea0;
            }
            a:hover {color: #82eaae}
            header {
                padding: 7vh 10vw;
                background: #ffebee;
            }
            header h1 {
                color: rgba(0,0,0,0.54);
            }
            .info {
                background: #009688;
                padding: 3vh 10vw;
                color: #d9d9d9;
            }
            /* Всплывающее окно
            * при загрузке сайта
            */
            /* базовый контейнер, фон затемнения*/
            #overlay {
                position: fixed;
                top: 0;
                left: 0;
                display: none;
                width: 100%;
                height: 100%;
                background: rgba(0, 0, 0, 0.65);
                z-index: 999;
                -webkit-animation: fade .6s;
                -moz-animation: fade .6s;
                animation: fade .6s;
                overflow: auto;
            }
            /* модальный блок */
            .popup {
                top: 25%;
                left: 0;
                right: 0;
                font-size: 14px;
                margin: auto;
                width: 85%;
                min-width: 320px;
                max-width: 600px;
                position: absolute;
                padding: 15px 20px;
                border: 1px solid #383838;
                background: #fefefe;
                z-index: 1000;
                -webkit-border-radius: 4px;
                -moz-border-radius: 4px;
                -ms-border-radius: 4px;
                border-radius: 4px;
                font: 14px/18px 'Tahoma', Arial, sans-serif;
                -webkit-box-shadow: 0 15px 20px rgba(0,0,0,.22),0 19px 60px rgba(0,0,0,.3);
                -moz-box-shadow: 0 15px 20px rgba(0,0,0,.22),0 19px 60px rgba(0,0,0,.3);
                -ms-box-shadow: 0 15px 20px rgba(0,0,0,.22),0 19px 60px rgba(0,0,0,.3);
                box-shadow: 0 15px 20px rgba(0,0,0,.22),0 19px 60px rgba(0,0,0,.3);
                -webkit-animation: fade .6s;
                -moz-animation: fade .6s;
                animation: fade .6s;
            }
            /* заголовки в модальном блоке */
            .popup h2, .popup h3 {
                margin: 0 0 1rem 0;
                font-weight: 300;
                line-height: 1.3;
                color: #009032;
                text-shadow: 1px 2px 4px #ddd;
            }
            /* кнопка закрытия */
            .close {
                top: 10px;
                right: 10px;
                width: 32px;
                height: 32px;
                position: absolute;
                border: none;
                -webkit-border-radius: 50%;
                -moz-border-radius: 50%;
                -ms-border-radius: 50%;
                -o-border-radius: 50%;
                border-radius: 50%;
                background-color: rgba(0, 131, 119, 0.9);
                -webkit-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
                -moz-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
                box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
                cursor: pointer;
                outline: none;

            }
            .close:before {
                color: rgba(255, 255, 255, 0.9);
                content: "X";
                font-family:  Arial, Helvetica, sans-serif;
                font-size: 14px;
                font-weight: normal;
                text-decoration: none;
                text-shadow: 0 -1px rgba(0, 0, 0, 0.9);
                -webkit-transition: all 0.5s;
                -moz-transition: all 0.5s;
                transition: all 0.5s;
            }
            /* кнопка закрытия при наведении */
            .close:hover {
                background-color: rgba(252, 20, 0, 0.8);
            }
            /* изображения в модальном окне */
            .popup img {
                width: 100%;
                height: auto;
                box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
            }
            /* миниатюры изображений */
            .pl-left,
            .pl-right {
                width: 25%;
                height: auto;
            }
            /* миниатюры справа */
            .pl-right {
                float: right;
                margin: 5px 0 5px 15px;
            }
            /* миниатюры слева */
            .pl-left {
                float: left;
                margin: 5px 18px 5px 0;
            }
            /* анимация при появлении блоков с содержанием */
            @-moz-keyframes fade {
                from { opacity: 0; }
                to { opacity: 1 }
            }
            @-webkit-keyframes fade {
                from { opacity: 0; }
                to { opacity: 1 }
            }
            @keyframes fade {
                from { opacity: 0; }
                to { opacity: 1 }
            }
        </style>


        <!-- Модальное Окно  -->
        <div id="overlay">
            <div class="popup">
                <p style="text-align: center">Доброго дня!</p>
                <p style="text-align: center">Можливість здійснення покупок доступна тільки для зареєстрованих користувачів</p>
                <p style="text-align: center">Щоб повноцінно користуватися можливостями нашого сайту Увійдіть або Зареєструйтеся</p>
                <p style="float: right"> &nbsp; Адміністрація</p>
                <button class="close" title="Закрыть" onclick="document.getElementById('overlay').style.display='none';"></button>
            </div>
        </div>
        <script src="http://yastatic.net/jquery/2.1.4/jquery.min.js"></script>
        <script src="http://yastatic.net/jquery/cookie/1.0/jquery.cookie.min.js"></script>
        <script type="text/javascript">
            $(function() {
                // кукіс виключив!!!!
        if (!$.cookie('hideModal')) {
                if ($.cookie('hideModal')) {
                    // если cookie не установлено появится окно
                    // с задержкой 5 секунд
                    var delay_popup = 5000;
                    setTimeout("document.getElementById('overlay').style.display='block'", delay_popup);
                }
//         Запоминаем в куках, что посетитель уже заходил
                $.cookie('hideModal', true, {
                    // Время хранения cookie в днях
                    expires: 1,
                    path: '/'
                });
            });
        </script>

    </div>
</div>