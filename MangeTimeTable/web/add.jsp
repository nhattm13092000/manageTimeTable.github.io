<%-- 
    Document   : AddNew
    Created on : May 31, 2021, 4:45:35 PM
    Author     : nhatbeo
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <jsp:useBean id="dao" scope="page" class="dao.DAO" />
    </head>
    <body>
        <div class="header_title">
            <img src="image/749020.png" alt=""/> <span> Add timetable </span>
        </div>
        <div class="addtimeTable">
            <form action="add" method="POST">
                <table border="1">
                    <tr style="background-color: gainsboro">
                        <td >Date</td>
                        <td >
                            <input type="date" name="date" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Slot</td>
                        <td>
                            <select name="slot">
                                <c:forEach var="o" items="${dao.allSlot}">
                                    <option value="${o.id}">${o.slotName}</option>
                                </c:forEach>
                            </select>  
                        </td>
                    </tr>
                    <tr style="background-color: gainsboro">
                        <td>Room</td>
                        <td>
                            <select name="room">
                                <c:forEach var="o" items="${dao.allRoom}">
                                    <option value="${o.id}">${o.name}</option>
                                </c:forEach>
                            </select>  
                            <span style="color: red;"> ${checkroom}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Teacher</td>
                        <td>
                            <select name="teacher">
                                <c:forEach var="o" items="${dao.allTeacher}">
                                    <option value="${o.id}">${o.code}</option>
                                </c:forEach>
                            </select>  
                            <span style="color: red;"> ${checkteacher}</span>
                        </td>
                    </tr>
                    <tr style="background-color: gainsboro">
                        <td>Class</td>
                        <td>
                            <select name="class">
                                <c:forEach var="o" items="${dao.allClasses}">
                                    <option value="${o.id}">${o.name}</option>
                                </c:forEach>
                            </select>  
                            <span style="color: red;"> ${checkclass}</span>
                        </td>
                    </tr>
                    <tr style="background-color: gainsboro">
                        <td></td>
                        <td>
                            <button type="submit">
                                Save
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
