package request;

import java.io.InputStream;

import server.SourceProcessor;

public class StaticHttpRequest extends HttpRequest {

    /**
     * @param input
     * @param uri
     */
    public StaticHttpRequest(InputStream input, String uri) {
        super(input, uri);
    }

    /** 
     * @see request.HttpRequest#getSourceProcessor()
     */
    @Override
    public SourceProcessor getSourceProcessor() {
        return null;
    }

}