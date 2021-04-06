<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/2
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息新增页面</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css">

    <!--jquery的框架：一定要先导入，因为bootstrap的框架需要使用jquery-->
    <script src="plugins/jquery-1.12.4/jquery-1.12.4.min.js" type="text/javascript"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body>

<div class="bs-example" data-example-id="hoverable-table">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>序号</th>
            <th>用户姓名</th>
            <th>密码</th>
            <th>注册日期</th>
            <th>联系电话</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.lstUsers}" var="eachRow" varStatus="st">
            <%--    eachRow 当前遍历的数据 是一个 userInfobean 实体类 --%>
            <tr>
                <th scope="row">${st.index+1}</th>
                <td>${eachRow.userName}</td>
                <td>${eachRow.userPsw}</td>
                <td>${eachRow.userRegisteDate}</td>
                <td>${eachRow.userTel}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
