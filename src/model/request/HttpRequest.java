/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package model.request;

import java.io.InputStream;

import processor.SourceProcessor;

/**
 * 
 * @author wb-zhanglu.y
 * @version $Id: Rquest.java, v 0.1 Jan 18, 2016 4:30:47 PM wb-zhanglu.y Exp $
 */
public abstract class HttpRequest {
    /**从socket获取得输入流*/
    private final InputStream input;

    /**http请求的URI*/
    private String            uri;

    /**
     * @param input
     * @param uri
     */
    public HttpRequest(InputStream input, String uri) {
        super();
        this.input = input;
        this.uri = uri;
    }

    public abstract SourceProcessor getSourceProcessor();

    public String getUri() {
        return this.uri;
    }

    public InputStream getInput() {
        return this.input;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}