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

public class HttpResponse {

    private HttpRequest            request;

    private final OutputStream output;

    public HttpResponse(OutputStream output) {
        this.output = output;
    }
    
    

    public HttpResponse(HttpRequest request, OutputStream output) {
		super();
		this.request = request;
		this.output = output;
	}



	public HttpRequest getRequest() {
        return request;
    }

    public OutputStream getOutput() {
        return output;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }
    

}