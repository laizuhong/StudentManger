<%--
  Created by IntelliJ IDEA.
  User: laizuhong
  Date: 2016/7/18
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>博客管理</title>
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
        <h1>全部博客<a href="/admin/blogs/add" type="button" class="btn btn-primary btn-sm">添加</a></h1>
        <c:if test="${empty bloglist}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Blog表为空，请<a href="/admin/blogs/add" type="button" class="btn btn-primary btn-sm">添加</a>
        </div>
        </c:if>

        <c:if test="${!empty bloglist}">
            <table class="table table-bordered table-striped">

                <tr>
                    <th>ID</th>
                    <th>标题</th>
                    <th>作者</th>
                    <th>发布日期</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${bloglist}" var="blog">

                    <tr>
                        <th>${blog.id}</th>
                        <th>${blog.title}</th>
                        <th>${blog.studentByUserId.nickname}</th>
                        <th>${blog.pubDate}</th>
                        <th>
                            <a href="/admin/blogs/show/${blog.id}" type="button" class="btn btn-sm btn-success">详情</a>
                            <a href="/admin/blogs/update/${blog.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                            <a href="/admin/blogs/delete/${blog.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                        </th>
                    </tr>
                </c:forEach>
            </table>


        </c:if>
    </div>
</body>
</html>
