<%--
  Created by IntelliJ IDEA.
  User: 赵金慧
  Date: 2019/12/26
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <script type="text/javascript" src="../js/calendar.js"></script>
    <link rel="stylesheet" type="text/css" href="style/style.css"></link>
    <style type="text/css">
        form {
            margin: 5px 0;
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

        #content div input {
            width: 200px;
        }

        fieldset.buttons {
            border: solid 1px #ffffff;
            text-align: center;
            display: block;
            margin-top: 20px;
        }

    </style>
    <title>新建订单</title>
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
        <form action="<%= request.getContextPath()%>/registerServlet">
            <fieldset>
                <legend>登录信息[必选]</legend>
                <div>
                    <label for="username">用户名</label>
                    <input type="text" name="username" id="username"/>
                </div>
                <div>
                    <label for="password">密码</label>
                    <input type="text" name="password" id="password"/>
                </div>
                <div>
                    <label for="repassword">重复密码</label>
                    <input type="text" name="repassword" id="repassword"/>
                </div>
            </fieldset>
            <fieldset>
                <legend>联系信息[可选]</legend>
                <div>
                    <label for="name">联系人</label>
                    <input type="text" name="name" id="name"/>
                </div>
                <div>
                    <label for="phone">联系电话</label>
                    <input type="text" name="phone" id="phone"/>
                </div>
                <div>
                    <label for="email">电子邮件</label>
                    <input type="text" name="email" id="email"/>
                </div>
            </fieldset>
            <fieldset class="buttons">
                <input type="submit" value="注册"/>
            </fieldset>
        </form>
    </div>
    <hr/>
    <div id="footer">
        <p>本系统做为Java Web教学设计使用。未经允许，不得做为它用，版权所有Allan<br/>联系方式：javamedia@live.cn</p>
    </div>
</div>
</body>
</html>
