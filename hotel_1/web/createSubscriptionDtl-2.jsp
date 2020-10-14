<%--
  Created by IntelliJ IDEA.
  User: 赵金慧
  Date: 2019/12/26
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <script type="text/javascript" src="js/calendar.js"></script>
    <link rel="stylesheet" type="text/css" href="style/style.css"></link>
    <style type="text/css">
        div.submit {
            text-align: center;
            margin-top: 15px;
            border: solid 1px #ffffff;
        }

        table {
            margin: auto;
            margin-top: 3px;
            width: 600px;
            border-collapse: collapse;
        }

        td {
            border: solid 1px #ffffff;
            padding: 6px 1px;
            text-align: center;
        }

        fieldset {
            border: 0;
        }

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
            <p>下面是满足您预订条件的房间，请选择一个或多个然后点击完成按钮，点击上一步可以更改预定条件。</p>
            <form action="createSubscriptionDtl-3.jsp">
                <fieldset>
                    <table>
                        <c:forEach items="romlist" var="Room" varStatus="s">
                            <tr>
                                <td>
                                    <label for="room_101">${Room.no}</label>
                                    <input type="checkbox" name="room_101" value="" id="room_101"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </fieldset>

                <div class="submit">
                    <input type="button" value="上一步" onclick="location='createSubscriptionDtl-1.jsp'"/>
                    <input type="submit" value="完成"/>
                </div>
            </form>
        </div>
    </div>
    <hr/>
    <div id="footer">
        <p>本系统为Java Web教学而设计，不得作为它用，版权所有Allan<br/>联系方式：javamedia@live.cn</p>
    </div>
</div>
</body>
</html>
