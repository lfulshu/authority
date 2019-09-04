package com.lz.common;

import com.lz.exception.AuthorityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liizzz
 * @Data 2019/9/4 22:22
 *
 * 接口请求全局处理逻辑
 *
 * 只有发生出现自己定义的异常，才返回数据给用户，否则返回默认的异常页面给用户
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        ModelAndView mav;
        String defaultMsg = "system error";

        /**
         * 这里做一个约定，如果是数据请求，那么url就是.json结尾
         * 如果是页面请求，那么url就是.page结尾
         */
        if (url.endsWith(".json")){
            if (ex instanceof AuthorityException){
                JsonData result = JsonData.fail(ex.getMessage());
                mav = new ModelAndView("jsonView",result.toMap());
            }else {
                log.error("unknown json exception, url:" + url, ex);
                JsonData result = JsonData.fail(defaultMsg);
                mav = new ModelAndView("jsonView",result.toMap());
            }
        }else if(url.endsWith(".page")){
            JsonData result = JsonData.fail(defaultMsg);
            mav = new ModelAndView("exception",result.toMap());
        }else {
            log.error("unknown page exception, url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            mav = new ModelAndView("jsonView",result.toMap());
        }

        return mav;
    }
}
