<%--
  Created by IntelliJ IDEA.
  User: laizuhong
  Date: 2016/7/18
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加博客</title>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container">
        <h1>添加博客</h1>
        <form:form action="/admin/blogs/addP" method="post" commandName="blogBean" role="form">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="Enter Title:"/>
            </div>
            <div class="form-group">
                <label for="studentByUserId.id">Author:</label>
                <select class="form-control" id="studentByUserId.id" name="studentByUserId.id">
                    <c:forEach items="${userlist}" var="user">
                        <option value="${user.id}">${user.nickname}, ${user.username}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="content">Content:</label>
                <textarea class="form-control" id="content" name="content" rows="3" maxlength="200" minlength="6" placeholder="Please Input Content"></textarea>
            </div>
            <%--<div class="form-group">--%>
                <%--<label for="pubDate">Publish Date:</label>--%>
                <%--<input type="date" id="pubDate" name="pubDate" class="form-control">--%>
            <%--</div>--%>
            <div class="form-group">
                <button type="submit" class="btn btn-sm btn-success">提交</button>
            </div>
        </form:form>
    </div>
</body>
</html>
