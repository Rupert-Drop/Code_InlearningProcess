<%--
  Created by IntelliJ IDEA.
  User: 赵金慧
  Date: 2019/12/26
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>修改密码</title>
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
            <form action="${pageContext.request.contextPath}/editPasswordServlet">
                <fieldset>
                    <legend>密码信息</legend>
                    <div>
                        <label for="password">原密码</label>
                        <input type="password" name="password" id="password"/>
                    </div>
                    <div>
                        <label for="newPassword">新密码</label>
                        <input type="password" name="newPassword" id="newPassword"/>
                    </div>
                    <div>
                        <label for="reNewPassword">重复新密码</label>
                        <input type="password" name="reNewPassword" id="reNewPassword"/>
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
