/**
 * 注册
 */
package com.yp.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yp.implement.RegisterImple;
import com.yp.inter.Register;
import com.yp.util.YP_CONST;

import net.sf.json.JSONObject;
/**
 * @author kevin
 *
 */
public class registerService extends HttpServlet {
    
    private static final long serialVersionUID = -6191717328309925704L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Register register = new RegisterImple();
        String account = req.getParameter("account");
        
        String result = register.checkUserCount(account);
        
        @SuppressWarnings("static-access")
        JSONObject resultJSON = new JSONObject().fromObject(result);
        
        // 错误
        if(resultJSON.getInt(YP_CONST.RES_CODE) != YP_CONST.SUCCESS) {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/xml");
            resp.getWriter().print(result);
        } else {
            String password = req.getParameter("password");
            
            result = register.newUser(account, password);
            
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/xml");
            resp.getWriter().print(result);
        }
    }
}
