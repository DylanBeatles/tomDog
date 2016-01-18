/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package util;

/**
 * �ַ���������
 * @author wb-zhanglu.y
 * @version $Id: StringUtil.java, v 0.1 Jan 18, 2016 1:31:29 PM wb-zhanglu.y Exp $
 */
public class StringUtil {
    /**���ַ���*/
    public static String EMPTY_STRING = "";

    /**
     * �ж��ַ����Ƿ�Ϊ��
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
     * �ж��ַ����Ƿ�Ϊ��
     * 
     * @param targetStr
     * @return
     */
    public static boolean isNotEmpty(String targetStr) {
        return !isEmpty(targetStr);
    }

    /**
     * �ж�sourceStr�ַ������Ƿ����targetStr
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
