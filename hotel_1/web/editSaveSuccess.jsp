<%--
  Created by IntelliJ IDEA.
  User: 赵金慧
  Date: 2020/1/1
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <script type="text/javascript" src="js/calendar.js"></script>
    <link rel="stylesheet" type="text/css" href="style/style.css"></link>
    <style type="text/css">
        #content p {
            text-align: center;
            margin-top: 20px;
        }

    </style>
    <title>预定客房</title>
</head>
<body>
<div id="container">
    <div id="header">
        <ul>
            <li><a href="#">帮助</a></li>
        </ul>
    </div>
    <div id="menu">
        <ul>
            <li><a href="index.jsp">首页</a></li>
            <li><a href="roomPrice.jsp">设施与价格</a></li>
            <li><a href="${pageContext.request.contextPath}/findAllMemberServlet">会员中心</a></li>
        </ul>
    </div>
    <div id="content">
        <p>信息修改成功，请<a href="login.jsp">重新登录</a>。</p>
    </div>
    <hr/>
    <div id="footer">
        <p>本系统为Java Web教学而设计，不得作为它用，版权所有Allan<br/>联系方式：javamedia@live.cn</p>
    </div>
</div>
</body>
</html>
