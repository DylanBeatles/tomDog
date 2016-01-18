package server;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import request.HttpRequest;
import response.HttpResponse;
import connector.RequestParser;
import constant.Constants;

public class HttpServer {

    /** WEB_ROOT is the directory where our HTML and other files reside.
     *  For this package, WEB_ROOT is the "webroot" directory under the working
     *  directory.
     *  The working directory is the location in the file system
     *  from where the java command was invoked.
     */
    public static final String  WEB_ROOT         = System.getProperty("user.dir") + File.separator
                                                   + "webroot";

    // shutdown command
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    // the shutdown command received
    private boolean             shutdown         = false;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = obtainServerSocket();

        serve(serverSocket);
    }

    /**
     * 开始服务
     * 
     * @param serverSocket
     */
    private void serve(ServerSocket serverSocket) {
        // Loop waiting for a request
        while (!shutdown) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();

                HttpRequest request = RequestParser.getInstance().parseRequest(socket.getInputStream());

                createAndSetResponse(socket, request);

                socket.close();

                //check if the previous URI is a shutdown command
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 创建并且设置Response
     * 
     * @param socket
     * @param request
     * @throws IOException
     */
    private void createAndSetResponse(Socket socket, HttpRequest request) throws IOException {
        // create Response object
        HttpResponse response = new HttpResponse(request, socket.getOutputStream());
        
        request.getSourceProcessor().process(request, response);
    }

    /**
     * 获取服务端的socket，地址是本机地址，端口号8080
     * 
     * @param serverSocket
     * @return
     */
    private ServerSocket obtainServerSocket() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(Constants.SERVER_PORT_STRING, 1,
                InetAddress.getByName(Constants.LOCAL_ADDRESS_STRING));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return serverSocket;
    }
}
