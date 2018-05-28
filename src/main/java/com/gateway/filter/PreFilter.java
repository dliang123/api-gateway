package com.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author dengliang
 * @Email liang.deng@atzuche.cn
 * @Date Created in 15:59 2018/5/28
 */
public class PreFilter extends ZuulFilter {

    private final static Logger logger = LoggerFactory.getLogger(PreFilter.class);
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String realIp=request.getHeader("X-Real-IP");
        logger.info("realIp is : {}",realIp);
        String xForwardIp = request.getHeader("X-Forwarded-For");
        logger.info("xForwardIp is {}",xForwardIp);
        requestContext.addZuulRequestHeader("X-Real-IP",realIp);
        String token = request.getHeader("Atzuche-Token");
        if(token.equals("123")){
            logger.info("token is valid");
            return null;
        }
        else{
            throw new RuntimeException("token is invalid!!!");
        }


    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
