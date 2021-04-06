package com.wjj.control;

import com.wjj.bean.UserInfoBean;
import com.wjj.modal.UserModel;
import com.wjj.utils.MyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserInfoAddServlet", value = "/UserInfoAddServlet")
public class UserInfoAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、设置编码【由filter来进行处理】
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");

        // 2、获取表单数据，并把表单数据保存到实例类中
        UserInfoBean userInfoBean = MyUtils.getNewInstance(UserInfoBean.class);
        userInfoBean.setUserName(request.getParameter("userName"));
        System.out.println("用户名："+request.getParameter("userName"));
        userInfoBean.setUserPsw(request.getParameter("userPsw"));
        userInfoBean.setUserTel(request.getParameter("userTel"));
        // 把从前台页面获取的表单数据的值转换为 日期 Date 类型
        String strRegiseterDate = request.getParameter("userRegisteDate");
        // 把前台页面传递的string类型转换为日期的date类型
        System.out.println("前台页面的日期字符串：" + strRegiseterDate);
        userInfoBean.setUserRegisteDate(MyUtils.convertString2Date(strRegiseterDate, "yyyy-MM-dd"));

        //System.out.println("日期类型："+userInfoBean.toString());
        // 3、调用model层进行数据保存的业务逻辑处理
        int i = MyUtils.getNewInstance(UserModel.class).saveUserInfo(userInfoBean);

        // 4、数据保存成功之后，跳转的保存结果显示页面
        if (i > 0) {
            // 保存成功，跳转到成功显示页面
            request.getRequestDispatcher("WEB-INF/viewpages/userInfoB/UserInfoAddDetail.jsp").forward(request, response);
        } else {
            // 保存失败，继续跳回新增页面
            request.getRequestDispatcher("WEB-INF/viewpages/userInfoB/UserInfoAdd.jsp").forward(request, response);
        }
    }
}
