<%--
  Created by IntelliJ IDEA.
  User: 赵金慧
  Date: 2019/12/26
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <script type="text/javascript" src="../js/calendar.js"></script>
    <link rel="stylesheet" type="text/css" href="style/style.css"></link>
    <style type="text/css">
        h1 {
            text-align: center;
            font-size: 1em;
            padding: 0.3em 0;
            margin-top: 20px;
        }

        div.submit {
            text-align: center;
            margin-top: 15px;
            border: solid 1px #ffffff;
        }

        table {
            margin: auto;
            margin-top: 5px;
            width: 720px;
            border-collapse: collapse;
        }

        th, td {
            border: solid 1px #000000;
            padding: 6px 1px;
        }

        .category {
            text-align: center;
        }

        .date {
            text-align: center;
        }

        .opt {
            text-align: center;
        }

        td div {
            text-align: center;
            margin: 0;
            padding: 0;
        }

        .text {
            width: 390px;
        }

    </style>
    <title>订单明细信息</title>
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
            <h1>订单明细信息管理</h1>
            <table>
                <colgroup>
                    <col class="category"/>
                    <col class="no"/>
                    <col/>
                    <col/>
                    <col span="2" class="date"/>
                    <col class="opt"/>
                </colgroup>
                <tr>
                    <th>房间类型</th>
                    <th>房间号</th>
                    <th>预定方式</th>
                    <th>单价</th>
                    <th>入住日期</th>
                    <th>退房日期</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${slist}" var="Subscription_dtl" varStatus="s">
                    <tr>
                        <td>
                            <div>标准间</div>
                        </td>
                        <td>
                            <div>${Subscription_dtl.rid}</div>
                        </td>
                        <td>
                            <div>${Subscription_dtl.residetype}</div>
                        </td>
                        <td>
                            <div>${Subscription_dtl.price}</div>
                        </td>
                        <td>${Subscription_dtl.sdate}</td>
                        <td>${Subscription_dtl.edate}</td>
                        <td>
                            <div>
                                <a href="${pageContext.request.contextPath}/room_DeletServlet?sid=${Subscription_dtl.sid}"
                                   onclick="return confirm('真的要删除该预定细信息吗？')">删除</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <div class="submit">
                <input type="button" value="返回"
                       onclick="location='${pageContext.request.contextPath}/findAllMemberServlet'"/>
                <input type="button" value="新增预定" onclick="location='createSubscriptionDtl-1.jsp'"/>
            </div>
        </div>
    </div>
    <hr/>
    <div id="footer">
        <p>本系统做为Java Web教学设计使用。未经允许，不得做为它用，版权所有Allan<br/>联系方式：javamedia@live.cn</p>
    </div>
</div>
</body>
</html>
