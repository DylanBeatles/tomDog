package connector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import model.constant.Constants;
import model.request.HttpRequest;
import model.response.HttpResponse;
import parser.Parser;

public class HttpConnector implements Runnable {
    // the shutdown command received
    private boolean             shutdown         = false;

	@Override
	public void run() {
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
                
                HttpRequest request = Parser.getInstance().parseRequest(
                    socket.getInputStream());

                createAndSetResponse(socket, request);

                socket.close();

                //check if the previous URI is a shutdown command
                shutdown = request.getUri().equals(Constants.SHUTDOWN_COMMAND);
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

        try {
            request.getSourceProcessor().process(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
