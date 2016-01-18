package response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import constant.Constants;
import request.HttpRequest;
import server.HttpServer;

/*
  HTTP Response = Status-Line
    *(( general-header | response-header | entity-header ) CRLF)
    CRLF
    [ message-body ]
    Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
*/

public class Response {

    private HttpRequest            request;

    private final OutputStream output;

    /**
     * ����̬����
     * 
     * @throws IOException
     */
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
    }

    public HttpRequest getRequest() {
        return request;
    }

    public OutputStream getOutput() {
        return output;
    }

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

}