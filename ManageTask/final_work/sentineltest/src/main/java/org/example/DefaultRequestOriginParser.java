package org.example;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class DefaultRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        //基于请求参数，进行黑白名单设计
//        String origin=request.getParameter("origin");
//        return origin;

        //基于ip地址，进行黑白名单设计
        String remoteAddr = request.getRemoteAddr();
        return remoteAddr;
    }
}
