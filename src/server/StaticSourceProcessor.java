/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import constant.Constants;
import request.HttpRequest;
import response.HttpResponse;

/**
 * 
 * @author wb-zhanglu.y
 * @version $Id: StaticSourceProcessor.java, v 0.1 Jan 18, 2016 5:19:47 PM wb-zhanglu.y Exp $
 */
public class StaticSourceProcessor implements SourceProcessor {

    /** 
     * @see server.SourceProcessor#process(request.HttpRequest)
     */
    @Override
    public void process(HttpRequest request, HttpResponse response) {

        byte[] bytes = new byte[Constants.RESPONSE_BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(BootStrap.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, Constants.RESPONSE_BUFFER_SIZE);
                while (ch != -1) {
                	response.getOutput().write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, Constants.RESPONSE_BUFFER_SIZE);
                }
            } else {
                // file not found
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
                                      + "Content-Type: text/html\r\n" + "Content-Length: 23\r\n"
                                      + "\r\n" + "<h1>File Not Found</h1>";
                response.getOutput().write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            // thrown if cannot instantiate a File object
            System.out.println(e.toString());
        } finally {
            if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        }
    
    }
    
    /**
     * ¥¶¿Ìæ≤Ã¨«Î«Û
     * 
     * @throws IOException
     *//*
    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[Constants.RESPONSE_BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, Constants.RESPONSE_BUFFER_SIZE);
                while (ch != -1) {
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, Constants.RESPONSE_BUFFER_SIZE);
                }
            } else {
                // file not found
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
                                      + "Content-Type: text/html\r\n" + "Content-Length: 23\r\n"
                                      + "\r\n" + "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            // thrown if cannot instantiate a File object
            System.out.println(e.toString());
        } finally {
            if (fis != null)
                fis.close();
        }
    }*/

}
