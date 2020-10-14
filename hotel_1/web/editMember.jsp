<%--
  Created by IntelliJ IDEA.
  User: 赵金慧
  Date: 2019/12/26
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link rel="stylesheet" type="text/css" href="style/style.css"></link>
    <style type="text/css">

        form {
            margin: 10px 0;
        }

        fieldset {
            padding: 0 1em 1em 1em;
            margin: auto;
            width: 400px;
            display: block;
        }

        fieldset div {
            margin: 5px 0;
        }

        legend {
            padding: 1em;
        }

        label {
            float: left;
            width: 100px;
        }

        fieldset div input {
            width: 200px;
        }

        fieldset.buttons {
            border: solid 1px #ffffff;
            text-align: center;
            display: block;
            margin-top: 20px;
        }
    </style>
    <title>会员中心</title>
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
    <div id="content" style="width:98%;position:relative">
        <div class="submenu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/findAllMemberServlet">客房预订</a></li>
                <li><a href="${pageContext.request.contextPath}/historySubscripServlet">历史订单</a></li>
                <li><a href="editMember.jsp">修改信息</a></li>
                <li><a href="editPassword.jsp">修改密码</a></li>
                <li><a href="${pageContext.request.contextPath}/exitServlet">退出系统</a></li>
            </ul>
        </div>
        <div class="subcontent">
            <form action="register-2.jsp">
                <fieldset>
                    <legend>联系信息</legend>
                    <div>
                        <label for="name">联系人</label>
                        <input type="text" name="name" id="name" value="${subscription.name}"/>
                    </div>
                    <div>
                        <label for="phone">联系电话</label>
                        <input type="text" name="phone" id="phone" value="${subscription.phone}"/>
                    </div>
                    <div>
                        <label for="email">电子邮件</label>
                        <input type="text" name="email" id="email" value="${subscription.email}"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input type="submit" value="保存"/>
                </fieldset>
            </form>
        </div>
    </div>
    <hr/>
    <div id="footer">
        <p>本系统做为Java Web教学设计使用。未经允许，不得做为它用，版权所有Allan<br/>联系方式：javamedia@live.cn</p>
    </div>
</div>
</body>
</html>
