/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package processor;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import model.constant.Constants;
import model.enumeration.DogExceptionEnum;
import model.request.HttpRequest;
import model.response.HttpResponse;
import servlet.Servlet;
import util.StringUtil;
import exception.DogException;

/**
 * 
 * @author wb-zhanglu.y
 * @version $Id: ServletSourceProcessor.java, v 0.1 Jan 18, 2016 5:20:04 PM wb-zhanglu.y Exp $
 */
public class ServletSourceProcessor implements SourceProcessor {

    /** 
     * @throws DogException 
     * @see processor.SourceProcessor#process(model.request.HttpRequest)
     */
    @Override
    public void process(HttpRequest request, HttpResponse response) throws Exception {
        String uri = request.getUri();
        if (StringUtil.isEmpty(uri)) {
            throw new DogException(DogExceptionEnum.NULL_URI);
        }
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);

        String repository = (new URL("file", null, new File(Constants.WEB_ROOT).getCanonicalPath()
                                                   + File.separator)).toString();
        URL[] urls = { new URL(null, repository, (URLStreamHandler) null) };
        URLClassLoader loader = new URLClassLoader(urls);
        Class servletClass = loader.loadClass(servletName);
        Servlet servlet = (Servlet) servletClass.newInstance();
        servlet.service(request, response);

    }

}
