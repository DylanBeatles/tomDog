/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package server;

import request.HttpRequest;

/**
 * 
 * @author wb-zhanglu.y
 * @version $Id: SourceProcessor.java, v 0.1 Jan 18, 2016 4:27:10 PM wb-zhanglu.y Exp $
 */
public interface SourceProcessor {
    /**
     * ¥¶¿Ìhttp«Î«Û
     * 
     * @param request
     */
    public void process(HttpRequest request);
}
