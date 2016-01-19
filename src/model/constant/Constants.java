/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package model.constant;

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

}
