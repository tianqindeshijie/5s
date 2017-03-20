package com.chinamobile.iot.security;

import com.alibaba.fastjson.JSON;
import com.chinamobile.iot.lightapp.mysql.config.Constant;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuetao on 2017/2/24.
 * <p>认证成功后调用的处理类</p>
 */
@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**
     * Instantiates a new Rest authentication success handler.
     */
    public RestAuthenticationSuccessHandler() {
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Integer userId = SecurityUtils.getCurrentUser().getUserId();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Constant.USER_ID, userId);
        response.getWriter().write(JSON.toJSONString(map));
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
