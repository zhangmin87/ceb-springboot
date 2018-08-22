package com.ceb.filter;

;

import com.ceb.common.TokenManager;

import com.ceb.shiro.DTO.UUser;
import net.sf.json.JSONObject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author by zhangmin on 2018/8/21.15:42
 * <p>ajax filter 为了session 失效后,前端ajax请求,没有响应，此filter为了提示用户没有登录</p>
 */
public class CustomizedAjaxFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        UUser uUser = TokenManager.getToken();

        if (null != uUser) {
            return Boolean.TRUE;
        }
        //判断是否ajax 请求
        if (isAjax(request,response)) {
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        Map<String ,String> map = new HashMap<>();
        map.put("status","303");
        map.put("message","用于长时间没有操作,请重新登录");
        respnseOut(response,map);
        return Boolean.FALSE;
    }

    /**
     * 判断请求是否是ajax请求
     *
     * @param request
     * @return
     */
    private boolean isAjax(ServletRequest request,ServletResponse response) {
        if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {
            //创建json解析格式
            Map<String ,String> map = new HashMap<>();
            map.put("status","300");
            map.put("message","没有登录,请重新登录");
            return true;
        }
        else {
            return false;
        }
    }

    //写入response 将流写入到respose
    private void respnseOut(ServletResponse response,Map<String,String> resultMap) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String outSring = JSONObject.fromObject(resultMap).toString();
            out.println(outSring);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != out) {
                out.flush();
                out.close();
            }
        }

    }
}
