<%@page contentType="text/html;charset=gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/style/style.css"></link>
    <style type="text/css">

        #content div {
            margin: 10px 0px;
        }

        div.submit {
            text-align: center;
        }

        label {
            width: 80px;
            display: block;
            float: left;
        }

        fieldset {
            width: 300px;
            margin: auto;
            margin-top: 20px;
            display: block;
        }

        fieldset select {
            width: 120px;
        }

        fieldset input {
            width: 120px;
        }

    </style>
    <title>��¼</title>
</head>
<body>
<div id="container">
    <div id="header">
        <ul>
            <li><a href="#">����</a></li>
        </ul>
    </div>
    <div id="menu">
        <ul>
            <li><a href="index.jsp">��ҳ</a></li>
            <li><a href="roomPrice.jsp">��ʩ��۸�</a></li>
            <li><a href="${pageContext.request.contextPath}/findAllMemberServlet">��Ա����</a></li>
        </ul>
    </div>
    <div id="content">

        <form action="<%= request.getContextPath()%>/loginServlet" method="post">
            <fieldset>
                <legend>��¼��Ϣ</legend>
                <div>
                    <label for="username">�û���</label>
                    <input type="text" name="username" id="username"/>
                </div>
                <div>
                    <label for="password">����</label>
                    <input type="text" name="password" id="password"/>
                </div>
            </fieldset>
            <div class="submit">
                <input type="submit" value="��¼"/>
                <p>�������ûע�ᣬ��<a href="register-1.jsp">�������ע��</a>��Ϊ��Ա��</p>
            </div>
        </form>


    </div>
    <hr/>
    <div id="footer">
        <p>��ϵͳ��ΪJava Web��ѧ���ʹ�á�δ��������������Ϊ���ã���Ȩ����Allan<br/>��ϵ��ʽ��javamedia@live.cn</p>
    </div>
</div>
</body>
</html>