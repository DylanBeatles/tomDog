/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package model.request;

/**
 * @author  wb-zhanglu.y
 * @version  $Id: OriginalRequestData.java, v 0.1 Jan 18, 2016 11:46:17 AM wb-zhanglu.y Exp $
 */
public class OriginalRequestData {
    /**http请求的内容长度*/
    private int          requestContentSize;

    /**将http请求转换为字节数组*/
    private final byte[] uriByteBuffer = new byte[2048];

    public int getRequestContentSize() {
        return requestContentSize;
    }

    public void setRequestContentSize(int requestContentSize) {
        this.requestContentSize = requestContentSize;
    }

    public byte[] getUriByteBuffer() {
        return uriByteBuffer;
    }

}