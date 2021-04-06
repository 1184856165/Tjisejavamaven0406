package com.wjj.modal;


import com.wjj.bean.UserInfoBean;
import com.wjj.dao.DBProvider;
import com.wjj.utils.MyUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserModel {


    /**
     * 查询所有的用户信息
     *
     * @return 查询结果集
     */
    public List<UserInfoBean> queryUserInfoAll() {
        List<UserInfoBean> lst = new ArrayList<>();
        // 查询语句
        String strSql = " select * from userinfo order by userid desc ";
        lst = MyUtils.getNewInstance(DBProvider.class).query(strSql, new BeanListHandler<>(UserInfoBean.class));
        return lst;
    }



    /**
     * 用户信息新增
     *
     * @param userInfoBean 参数实体类
     * @return 数据保存成果的记录
     */
    public int saveUserInfo(UserInfoBean userInfoBean) {
        // 默认返回值
        int i = 0;
        // 数据保存的sql语句
        String strSql = "INSERT into userinfo(userName,userPsw,userTel,userRegisteDate) VALUES(?,?,?,?)";
        // 调用数据库操作dao层进行数据库保存处理
        i = MyUtils.getNewInstance(DBProvider.class).execute(strSql, new Object[]{
                userInfoBean.getUserName(), userInfoBean.getUserPsw(), userInfoBean.getUserTel()
                , MyUtils.convertDate2String(userInfoBean.getUserRegisteDate(),"yyyy-MM-dd HH:mm:ss")  // 需要把日期 Date类型转换为字符串
        });
        return i;
    }


    /**
     * 验证用户是否登录成功
     *
     * @param userName 用户名
     * @param userPsw  密码
     * @return 验证结果
     */
    public boolean doLogin(String userName, String userPsw) {
        // 默认返回值
        boolean canLogined = false;

        // 查询sql语句
        String strSql = "SELECT * FROM userinfo WHERE username = ? AND userpsw = ?";
        // 创建查询器对象
        //DBProvider dbProvider = new DBProvider();
        //List<Map<String, Object>> list = MyUtils.getNewInstance(DBProvider.class).queryListMap(strSql, userName, userPsw);
        List<Map<String, Object>> list = MyUtils.getNewInstance(DBProvider.class).query(strSql, new MapListHandler(), userName, userPsw);
        // 判断是否登录成功
        if (list != null && list.size() > 0) {
            // 登录成功
            canLogined = true;
        }
        // 返回值
        return canLogined;
    }

}
