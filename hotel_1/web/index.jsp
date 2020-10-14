<%--
  Created by IntelliJ IDEA.
  User: 赵金慧
  Date: 2019/12/26
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <link rel="stylesheet" type="text/css" href="style/style.css"></link>
    <style type="text/css">
        img {
            margin-right: 5px;
            margin-bottom: 5px;
            border: 0;
            float: right;
        }

        p {
            margin: 0;
            padding: 0;
            padding-top: 15px;
            border: solid 1px #ffffff;
        }

        table {
            padding: 0;
            margin: 0;
        }

        td {
            padding: 3px 1px;
            border: solid 1px #ffffff;
        }

        form {
            margin: 0;
            padding: 0;
        }

        label {
            width: 70px;
        }

        input.field {
            width: 90px;
        }

        div.buttons {
            padding: 5px 0;
            text-align: center;
            border: solid 1px #ffffff;
        }

        div.login {
            width: 160px;
            border: dashed 1px #00FFCC;
            float: left;
            margin: 15px 8px 5px 0;
        }

    </style>
    <title>腾达宾馆</title>
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


        <div class="login">

            <form action="<%= request.getContextPath()%>/loginServlet" method="post">
                <table>
                    <tr>
                        <td>
                            <label for="username">用户名</label>
                        </td>
                        <td>
                            <input type="text" name="username" id="username" class="field"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password">密码</label>
                        </td>
                        <td>
                            <input type="text" name="password" id="password" class="field"/>
                        </td>
                    </tr>
                </table>
                <div class="buttons">
                    <input type="submit" value="登录"/>
                    <input type="button" value="注册" onclick="location='register-1.jsp'"/>
                </div>
            </form>
        </div>
        <p>
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
        </p>
        <img src="images/hotel001.jpg"/>
        <p>
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
            腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区，　腾达宾馆，开业于2008年8月8日，它位于北京中关村高科技园区
        </p>
    </div>
    <hr/>
    <div id="footer">
        <p>本系统为Java Web教学而设计，不得作为它用，版权所有Allan<br/>联系方式：javamedia@live.cn</p>
    </div>
</div>
</body>
</html>
