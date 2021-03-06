/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package model.constant;

import java.io.File;

/**
 * 
 * @author wb-zhanglu.y
 * @version $Id: Constants.java, v 0.1 Jan 18, 2016 11:17:46 AM wb-zhanglu.y Exp $
 */
public class Constants {
    /**服务端口*/
    public static final int    SERVER_PORT_STRING         = 8080;

    /**本机地址*/
    public static final String LOCAL_ADDRESS_STRING       = "127.0.0.1";

    /**解析请求出错时，默认设置的请求内容长度*/
    public static final int    ERROR_REQUEST_CONTENT_SIZE = -1;

    /**响应中默认的返回的字节码长度*/
    public static final int    RESPONSE_BUFFER_SIZE       = 1024;

    /**servlet请求中标志字段*/
    public static final String SERCLET_REQUEST_FLAG       = "/servlet/";

    /** WEB_ROOT is the directory where our HTML and other files reside.
     *  For this package, WEB_ROOT is the "webroot" directory under the working
     *  directory.
     *  The working directory is the location in the file system
     *  from where the java command was invoked.
     */
    public static final String WEB_ROOT                   = System.getProperty("user.dir")
                                                            + File.separator + "webroot";
    
    /**服务器关闭命令*/
    public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

}
