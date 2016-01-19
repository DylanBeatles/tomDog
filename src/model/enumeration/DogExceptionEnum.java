/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package model.enumeration;


/**
 * 
 * @author wb-zhanglu.y
 * @version $Id: DogExceptionEnum.java, v 0.1 Jan 19, 2016 2:59:27 PM wb-zhanglu.y Exp $
 */
public enum DogExceptionEnum {

    /**请求静态资源*/
    NULL_URI("0001", "请求URI为空"), ;

    private String code;

    private String desc;

    /**
     * @param code
     * @param desc
     */
    private DogExceptionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
