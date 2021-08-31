<%-- 
    Document   : HomePage
    Created on : May 31, 2021, 4:27:29 PM
    Author     : nhatbeo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header_title">
            <img src="image/749020.png" alt=""/> <span> Time table </span>
        </div>
        <form action="home" method="POST">

            <div class="search_nav">
                <div class="sellectdate">
                    <h3>From Date</h3>
                    <input type="date" name="fromdate" value="${from}" />
                </div>
                <div class="sellectdate">
                    <h3>To Date</h3>
                    <input type="date" name="todate" value="${to}" />
                </div>
                <div class="button_search">
                    <button type="submit">
                        Search
                    </button>
                </div>
                <div class="addtime">
                    <a href="add.jsp"> Add timetable</a>
                </div>
            </div>
        </form>
        <div class="timetable">
            <table border="1">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Tiết</th>
                        <th>Time</th>
                        <th>Class</th>
                        <th>Teacher</th>
                        <th>Room</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="o" items="${listT}">
                        <tr>
                            <td style="background-color: #dcdcdc;">${o.getDate()}</td>
                            <td style="background-color: #dcdcdc;">${o.slot}</td>
                            <td style="background-color: #dcdcdc;">${o.getTimeFrom()} - ${o.getTimeTo()}</td>
                            <td style="color: #3b8dbc;background-color: #dcdcdc;">${o.className}</td>
                            <td style="background-color: #dcdcdc;"> ${o.teacherCode}</td>
                            <td style="background-color: #dcdcdc;">${o.roomName}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
