/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package enumeration;

import util.StringUtil;

/**
 * 请求类型的枚举类
 * @author wb-zhanglu.y
 * @version $Id: RequestTypeEnum.java, v 0.1 Jan 18, 2016 3:23:18 PM wb-zhanglu.y Exp $
 */
public enum RequestTypeEnum {
    /**请求静态资源*/
    STATIC_TYPE("01", "静态资源请求"),

    /**请求servlet*/
    SERVLET_TYPE("02", "servlet请求"),

    /**默认类型，当根据code取不到对应的枚举实例对象时返回该对象，防止调用客户端出现空指针*/
    DEFAULT_TYPE("03", StringUtil.EMPTY_STRING);

    private String code;

    private String desc;

    /**
     * @param code
     * @param desc
     */
    private RequestTypeEnum(String code, String desc) {
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
