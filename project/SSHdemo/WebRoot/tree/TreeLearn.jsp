<%-- 
    Document   : TreeLearn
    Created on : 2008-12-28, 17:23:16
    Author     : lichen6928
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <base href="<%=basePath%>">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="lib/ext/resources/css/ext-all.css" />
        <script type="text/javascript" src="lib/ext/adapter/ext/ext-base.js"></script>
        <script type="text/javascript" src="lib/ext/ext-all.js"></script>
        <script type="text/javascript" src="lib/ext/ext-lang-zh_CN.js"></script>
        <script type="text/javascript" src="script/javascript/AjaxTest.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>tree<%=  request.getContextPath()%></h1>
        <div id="tree"></div>
   </body>
</html>
