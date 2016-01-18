/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package util;

/**
 * ×Ö·û´®¹¤¾ßÀà
 * @author wb-zhanglu.y
 * @version $Id: StringUtil.java, v 0.1 Jan 18, 2016 1:31:29 PM wb-zhanglu.y Exp $
 */
public class StringUtil {
    /**¿Õ×Ö·û´®*/
    public static String EMPTY_STRING = "";

    /**
     * ÅĞ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
     * 
     * @param targetStr
     * @return
     */
    public static boolean isEmpty(String targetStr) {
        if (targetStr == null || targetStr.length() == 0) {
            return true;
        }

        return false;
    }

    /**
     * ÅĞ¶Ï×Ö·û´®ÊÇ·ñ²»Îª¿Õ
     * 
     * @param targetStr
     * @return
     */
    public static boolean isNotEmpty(String targetStr) {
        return !isEmpty(targetStr);
    }

    /**
     * ÅĞ¶ÏsourceStr×Ö·û´®ÖĞÊÇ·ñ°üº¬targetStr
     * 
     * @param sourceStr
     * @param targetStr
     * @return
     */
    public static boolean contains(String sourceStr, String targetStr) {
        if (isEmpty(targetStr)) {
            return false;
        }

        if (sourceStr.indexOf(targetStr) >= 0) {
            return true;
        }

        return false;
    }

}
