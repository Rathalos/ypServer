/**
 * ע��
 */

package com.yp.inter;

public interface Register {

    // 查询用户名是否已被使用
    public String checkUserCount(String cell);
    
    // 添加用户
    public String newUser(String account, String password);
}
