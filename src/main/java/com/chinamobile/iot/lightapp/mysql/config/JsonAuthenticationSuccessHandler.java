package com.chinamobile.iot.lightapp.mysql.config;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuetao on 2017/2/24.
 */
public class JsonAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public JsonAuthenticationSuccessHandler() {
    }
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Map<String,String> map = new HashMap<String,String>();
        map.put(Constant.SESSION_NAME,session.getId());
        response.getWriter().write(JSON.toJSONString(map));
        response.setStatus(200);
    }
}
