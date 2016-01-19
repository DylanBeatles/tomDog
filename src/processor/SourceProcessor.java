/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package processor;

import model.request.HttpRequest;
import model.response.HttpResponse;

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
     * @throws Exception 
     */
    public void process(HttpRequest request, HttpResponse response) throws Exception;
}
