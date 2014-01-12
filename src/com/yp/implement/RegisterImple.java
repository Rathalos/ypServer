package com.yp.implement;

import java.sql.Statement;

import com.yp.inter.Register;
import com.yp.util.BaseDao;
import com.yp.util.Md5Util;
import com.yp.util.YP_CONST;

import net.sf.json.JSONObject;

public class RegisterImple extends BaseDao implements Register {

    // 返回结果
    JSONObject result = new JSONObject();
    
    @Override
    public String checkUserCount(String cell) {
        
        try{
            open();
            
            StringBuffer query = new StringBuffer();
            
            query.append("SELECT COUNT(0) ");
            query.append("FROM yp_tb_register YTRE ");
            query.append("WHERE YTRE.CELLPHONE = '" + cell + "'");
            
            st = conn.createStatement();
            rs = st.executeQuery(query.toString());
            
            while(rs.next()) {
                if (rs.getInt("COUNT(0)") == 0) {
                    result.put(YP_CONST.RES_CODE, YP_CONST.SUCCESS);
                    result.put(YP_CONST.RES_MSG, "该用户名可以使用");
                } else {
                    result.put(YP_CONST.RES_CODE, YP_CONST.FAIL);
                    result.put(YP_CONST.RES_MSG, "该用户名已被使用");
                }
            }
            
        } catch(Exception e) {
            result.put(YP_CONST.RES_CODE, YP_CONST.ERROR);
            result.put(YP_CONST.RES_MSG, "数据库连接失败");
        } finally {
            close();
        }
        
        return result.toString();
    }

    @Override
    // 创建用户
    public String newUser(String account,String password) {
        
        String AccessToken = "";
        
        try {
            open();
            
            // 加密
            password = Md5Util.getMD5Str(password);
            
            StringBuffer query = new StringBuffer();
            
            query.append("INSERT INTO yp_tb_register ( CELLPHONE, PASSWORD, LEGAL_FLAG, CREATE_AT, UPDATE_AT ) VALUES (?,?,?,?,?) '");

            pst = conn.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, account);
            pst.setString(2, password);
            pst.setInt(3, YP_CONST.UNSUBBMIT);
            pst.setInt(4, 1000000); // TODO 时间戳
            pst.setInt(5, 1000000); // TODO 时间戳
            pst.executeUpdate();
            
            // 取得自动生成的主键的结果集
            rs = pst.getGeneratedKeys();
            
            while(rs.next()){
                int userId = rs.getInt(1) ;
                result.put(YP_CONST.RES_CODE, YP_CONST.SUCCESS);
                result.put("AccessToken", ""); // TODO 生成accesstoken
                result.put("userId", userId);
             }
            
        } catch(Exception e) {
            result.put(YP_CONST.RES_CODE, YP_CONST.ERROR);
            result.put(YP_CONST.RES_MSG, "数据库连接失败");
        } finally {
            close();
        }
        
        return AccessToken;
    }

}
