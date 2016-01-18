/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package connector;

import java.io.IOException;
import java.io.InputStream;

import request.HttpRequest;
import request.HttpRequestFactory;
import request.OriginalRequestData;
import constant.Constants;

/**
 * Request解析器
 * 
 * @author wb-zhanglu.y
 * @version $Id: UriParser.java, v 0.1 Jan 18, 2016 2:58:53 PM wb-zhanglu.y Exp $
 */
public class RequestParser {
    private static RequestParser instance = new RequestParser();

    /**
     * 根据输入流创建http请求的领域模型对象
     * 
     * @param inputStream
     * @return
     */
    public HttpRequest parseRequest(InputStream inputStream) {
        OriginalRequestData originalRequest = obtainOriginalRequestData(inputStream);
        String uri = extractUri(originalRequest);

        return HttpRequestFactory.createHttpRequest(inputStream, uri);
    }

    public static RequestParser getInstance() {
        if (instance == null) {
            instance = new RequestParser();
        }
        return instance;

    }

    private RequestParser() {
    }

    /**
     * 将http请求转换为对应的原始请求数据模型
     * 
     * @return
     */
    private OriginalRequestData obtainOriginalRequestData(InputStream inputStream) {
        OriginalRequestData originalRequest = new OriginalRequestData();
        try {
            originalRequest.setRequestContentSize(inputStream.read(originalRequest
                .getUriByteBuffer()));
        } catch (IOException e) {
            e.printStackTrace();
            originalRequest.setRequestContentSize(Constants.ERROR_REQUEST_CONTENT_SIZE);
        }

        return originalRequest;
    }

    /**
     * 从原始请求数据模型中提取请求URI
     * 
     * @param originalRequest
     * @return
     */
    private String extractUri(OriginalRequestData originalRequest) {
        StringBuffer uriBuffer = new StringBuffer();
        for (int index = 0; index < originalRequest.getRequestContentSize(); index++) {
            uriBuffer.append((char) originalRequest.getUriByteBuffer()[index]);
        }

        return parseUri(uriBuffer.toString());
    }

    private String parseUri(String requestString) {
        int requestMethodindexndex;
        int requestUrindexindex;
        requestMethodindexndex = requestString.indexOf(' ');
        if (requestMethodindexndex != -1) {
            requestUrindexindex = requestString.indexOf(' ', requestMethodindexndex + 1);
            if (requestUrindexindex > requestMethodindexndex)
                return requestString.substring(requestMethodindexndex + 1, requestUrindexindex);
        }
        return null;
    }

}
