<%--
  Created by IntelliJ IDEA.
  User: 赵金慧
  Date: 2019/12/26
  Time: 18:49
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
        div.submit {
            text-align: center;
            margin-top: 15px;
            border: solid 1px #ffffff;
        }

        label {
            float: left;
            width: 80px;
            text-align: left;
        }

        fieldset {
            position: relative;
            width: 300px;
            margin: auto;
            margin-top: 20px;
        }

        fieldset select {
            width: 120px;
        }

        fieldset input {
            width: 120px;
        }

        div.row {
            position: relative;
            padding: 8px 0;
            border: solid 1px #ffffff;
        }

        div.column {
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
            <p>请输入您要预定的房间类型以及预订的起始日期，系统会显示可用的房间并供您选择。</p>
            <form action="${pageContext.request.contextPath}/createSubscriptionDtlServlet">
                <fieldset>
                    <div class="row">

                    </div>

                    <div class="row">
                        <div class="column">
                            <label for="bookType">预定方式</label>
                            <select name="bookType" id="bookType">
                                <option value="1">单个床位</option>
                                <option value="2">整个房间</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="column">
                            <label for="startDate">开始日期</label>
                            <input type="text" name="startDate" id="startDate" readonly="readonly"
                                   onclick="new Calendar().show(this)"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="column">
                            <label for="endDate">结束日期</label>
                            <input type="text" name="endDate" id="endDate" readonly="readonly"
                                   onclick="new Calendar().show(this)"/>
                        </div>
                    </div>
                </fieldset>
                <div class="submit">
                    <input type="button" value="返回" onclick="location='subscriptionDetail.jsp'"/>
                    <input type="submit" value="下一步"/>
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
