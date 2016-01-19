/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package servlet;

import model.request.HttpRequest;
import model.response.HttpResponse;

/**
 * 
 * @author wb-zhanglu.y
 * @version $Id: Servlet.java, v 0.1 Jan 19, 2016 1:46:48 PM wb-zhanglu.y Exp $
 */
public interface Servlet {

    /**
     * 该方法是servlet对外提供服务的方法
     * 
     * @param request
     * @param response
     */
    public void service(HttpRequest request, HttpResponse response);

}
