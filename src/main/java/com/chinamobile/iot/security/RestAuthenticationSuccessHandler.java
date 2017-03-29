package com.chinamobile.iot.security;

import com.alibaba.fastjson.JSON;
import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        User user = SecurityUtils.getCurrentUser();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(Constant.SUCCESS_CODE);
        baseResponse.setMsg(Constant.SUCCESS_MSG);
        baseResponse.setData(user);
        response.getWriter().write(JSON.toJSONString(baseResponse));
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
