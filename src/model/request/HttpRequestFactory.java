/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package model.request;

import java.io.InputStream;

import model.constant.Constants;
import util.StringUtil;

/**
 * HttpRequest的工厂方法
 * 
 * @author wb-zhanglu.y
 * @version $Id: HttpRequestFactory.java, v 0.1 Jan 18, 2016 5:00:39 PM wb-zhanglu.y Exp $
 */
public class HttpRequestFactory {
    public static HttpRequest createHttpRequest(InputStream inputStream, String requestedUri) {
        HttpRequest request;

        if (StringUtil.isNotEmpty(requestedUri)
            && StringUtil.contains(requestedUri, Constants.SERCLET_REQUEST_FLAG)) {
            request = new StaticHttpRequest(inputStream, requestedUri);
        } else {
            request = new ServletHttpRequest(inputStream, requestedUri);
        }
        return request;
    }
}
