<%@ page import="cn.domain.Manager" %>
<%@ page import="cn.domain.Subscription" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 赵金慧
  Date: 2019/12/26
  Time: 17:29
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

        table {
            margin: auto;
            margin-top: 0;
            border-collapse: collapse;
            width: 90%;
        }

        th, td {
            border: solid 1px #000000;
        }

        th {
            padding: 6px 1px;
        }

        td {
            padding: 8px 1px;
        }

        td div {
            text-align: center;
        }

        .date {
            width: 50px;
            text-align: center;
        }

        #content div.button {
            text-align: center;
            padding-top: 15px;
        }

        #content p {
            margin: 20px 0;
            text-indent: 2em;
            line-height: 1.5em;
            text-align: center;
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
            <li><a href="${pageContext.request.contextPath}/loginViewServlet">首页</a></li>
            <li><a href="roomPrice.jsp">设施与价格</a></li>
            <li><a href="${pageContext.request.contextPath}/findAllMemberServlet">会员中心</a></li>
        </ul>
    </div>
    <div id="content" style="width:98%;position:relative">
        <div class="submenu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/findAllMemberServlet">客房预订</a></li>
                <li><a href="${pageContext.request.contextPath}/historySubscripServlet">历史订单</a></li>
                <li><a href="${pageContext.request.contextPath}/eidtMemberServlet">修改信息</a></li>
                <li><a href="editPassword.jsp">修改密码</a></li>
                <li><a href="${pageContext.request.contextPath}/exitServlet">退出系统</a></li>
            </ul>
        </div>
        <div class="subcontent">
            <p>
                下面是尚未确认的预定信息，您可以增加、修改或删除订单信息。
            </p>
            <table align="center">
                <colgroup>
                    <col class="datetime"/>
                    <col class="no"/>
                    <col/>
                    <col/>
                    <col/>
                    <col/>
                </colgroup>
                <tr>
                    <th>创建时间</th>
                    <th>订单号</th>
                    <th>联系人</th>
                    <th>联系电话</th>
                    <th>电子邮件</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${slist}" var="Subscription" varStatus="s">
                    <tr>
                        <td>
                            <div>${Subscription.cretime}</div>
                        </td>
                        <td>
                            <div><a href="#">${Subscription.no}</a></div>
                        </td>
                        <td>
                            <div>${Subscription.linkman}</div>
                        </td>
                        <td>${Subscription.phone}</td>
                        <td>${Subscription.email}</td>
                        <td>
                            <div>
                                <a href="${pageContext.request.contextPath}/deletSubscriptionServlet?id=${Subscription.id}"
                                   onclick="return confirm('真的要删除该订单及其明细信息吗？')">删除</a>
                                <a href="${pageContext.request.contextPath}/editSubscriptionServlet?no=${Subscription.no}">联系人信息</a>
                                <a href="${pageContext.request.contextPath}/roomSelectServlet?sid=${Subscription.no}">客房信息</a>
                            </div>
                        </td>
                    </tr>

                </c:forEach>

            </table>
            <div class="button">
                <input type="button" value="新建订单" onclick="location='newSubscription.jsp'"/>
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
