/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package enumeration;

import util.StringUtil;

/**
 * �������͵�ö����
 * @author wb-zhanglu.y
 * @version $Id: RequestTypeEnum.java, v 0.1 Jan 18, 2016 3:23:18 PM wb-zhanglu.y Exp $
 */
public enum RequestTypeEnum {
    /**����̬��Դ*/
    STATIC_TYPE("01", "��̬��Դ����"),

    /**����servlet*/
    SERVLET_TYPE("02", "servlet����"),

    /**Ĭ�����ͣ�������codeȡ������Ӧ��ö��ʵ������ʱ���ظö��󣬷�ֹ���ÿͻ��˳��ֿ�ָ��*/
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
