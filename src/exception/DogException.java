/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package exception;

import model.enumeration.DogExceptionEnum;
import util.StringUtil;

/**
 * 
 * @author wb-zhanglu.y
 * @version $Id: DogException.java, v 0.1 Jan 19, 2016 2:57:53 PM wb-zhanglu.y Exp $
 */
public class DogException extends Exception {
    /**default versionId*/
    private static final long serialVersionUID = 1L;

    private String            errorCode;

    private String            errorDesc;

    public String getErrorCode() {
        return errorCode;
    }

    public DogException(DogExceptionEnum exceptionEnum) {
        this.errorCode = exceptionEnum.getCode();
        this.errorDesc = exceptionEnum.getDesc();
    }

    @Override
    public String toString() {
        return this.errorCode + StringUtil.EMPTY_STRING + this.errorDesc;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

}
