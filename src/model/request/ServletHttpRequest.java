/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package model.request;

import java.io.InputStream;

import processor.ServletSourceProcessor;
import processor.SourceProcessor;

/**
 * 
 * @author wb-zhanglu.y
 * @version $Id: ServletHttpRequest.java, v 0.1 Jan 18, 2016 4:53:10 PM wb-zhanglu.y Exp $
 */
public class ServletHttpRequest extends HttpRequest {

    /**
     * @param input
     * @param uri
     */
    public ServletHttpRequest(InputStream input, String uri) {
        super(input, uri);
    }

    /** 
     * @see model.request.HttpRequest#getSourceProcessor()
     */
    @Override
    public SourceProcessor getSourceProcessor() {
        return new ServletSourceProcessor();
    }

}
