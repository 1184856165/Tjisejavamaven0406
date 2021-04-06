<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/2
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息添加</title>
    <link rel="shortcut icon" href="favicon.ico"> <link href="plugins/Hplus-v.4.1.0/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plugins/Hplus-v.4.1.0/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="plugins/Hplus-v.4.1.0/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="plugins/Hplus-v.4.1.0/css/animate.css" rel="stylesheet">
    <link href="plugins/Hplus-v.4.1.0/css/style.css?v=4.1.0" rel="stylesheet">

    <!-- 全局js -->
    <script src="plugins/Hplus-v.4.1.0/js/jquery.min.js?v=2.1.4"></script>
    <script src="plugins/Hplus-v.4.1.0/js/bootstrap.min.js?v=3.3.6"></script>
</head>
<body>
<div class="ibox-content">
    <form action="UserInfoAddServlet" method="post" class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">用户名</label>

            <div class="col-sm-2">
                <input type="text" id="userName" name="userName" class="form-control">
            </div>
        </div>

        <div class="hr-line-dashed"></div>

        <div class="form-group">
            <label class="col-sm-2 control-label">密码</label>
            <div class="col-sm-2">
                <input type="password"  id="userPsw" name="userPsw"  class="form-control"> <span class="help-block m-b-none">密码由字母、数字、特殊符号组成</span>
            </div>
        </div>

        <div class="hr-line-dashed"></div>

        <div class="form-group">
            <label class="col-sm-2 control-label">确认密码</label>

            <div class="col-sm-2">
                <input type="password"  id="userPsw2" name="userPsw2"  class="form-control" name="password">
            </div>
        </div>

        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">联系电话</label>

            <div class="col-sm-2">
                <input type="text" id="userTel" name="userTel" class="form-control">
            </div>
        </div>

        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <label class="col-sm-2 control-label">注册日期</label>

            <div class="col-sm-2">
                <input type="date"  id="userRegisteDate" name="userRegisteDate"  placeholder="选择注册日期" class="form-control">
            </div>
        </div>
        <div class="hr-line-dashed"></div>
        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-2">
                <button class="btn btn-primary" type="submit">保存内容</button>
                <%--                <button class="btn btn-white" type="submit">取消</button>--%>
            </div>
        </div>
    </form>
</div>

</body>
</html>
