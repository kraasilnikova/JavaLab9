<%--
  Created by IntelliJ IDEA.
  User: Маша
  Date: 20.05.2021
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" pageEncoding="UTF-8" %>
<%-- Импортировать JSTL-библиотеку --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Удалить из сессии JavaBean с данными пользователя --%>
<c:remove var="authUser" scope="session" />
<%-- Переадресовать на начальную страницу --%>
<c:redirect url="/index.jsp" />