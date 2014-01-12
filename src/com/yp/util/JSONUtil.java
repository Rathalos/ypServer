/**
 * 将request内容转成JSON
 */
package com.yp.util;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class JSONUtil {

    public static JSONObject readJSONString(HttpServletRequest request){
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch(Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(YP_CONST.RES_CODE, YP_CONST.ERROR);
            jsonObject.put(YP_CONST.RES_MSG, "读取失败");
            return jsonObject;
        }

        @SuppressWarnings("static-access")
        JSONObject jsonObject = new JSONObject().fromObject(json);
        return jsonObject;
    }

    public static JSONObject readJSONString(String value){
        StringBuffer json = new StringBuffer();
        json.append(value);

        @SuppressWarnings("static-access")
        JSONObject jsonObject = new JSONObject().fromObject(json);
        return jsonObject;
    }
}
