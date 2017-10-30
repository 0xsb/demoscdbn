package com.cmcc.ms.csrf;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author pactera
 *
 */
public class CsrfSecurityRequestMatcher implements RequestMatcher {
    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

    @Override
    public boolean matches(HttpServletRequest request) {

        if (execludeUrls != null && execludeUrls.size() > 0) {
            String servletPath = request.getServletPath();
            for (String url : execludeUrls) {
                if ("POST".equals(request.getMethod())) {
                    if (servletPath.contains(url)) {
                        System.out.println("---------排除掉的post方法--------" + servletPath);
                        return false;
                    }
                }
            }
        }
        return !allowedMethods.matcher(request.getMethod()).matches();
    }

    /**
     * 需要排除的url列表
     */
    private List<String> execludeUrls;

    public List<String> getExecludeUrls() {
        return execludeUrls;
    }

    public void setExecludeUrls(List<String> execludeUrls) {
        this.execludeUrls = execludeUrls;
    }
}
