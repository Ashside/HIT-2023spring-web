package com.example.demo3.dao.impl;

import com.example.demo3.dao.LoginDao;
import com.example.demo3.db.DBUtil;

import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {
    public boolean login(String uid, String pwd) {
        DBUtil dbUtil = new DBUtil();
        String sql = "select count(*) from admin where uid = '" + uid + "' and pwd = '" + pwd + "'";
        System.out.println(sql);
        ResultSet rs = dbUtil.executeQuery(sql);
        int count = 0;
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            dbUtil.close();
            return count == 1? true : false;
        }
    }
}
