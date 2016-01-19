package startup;


import connector.HttpConnector;

public class BootStrap {

    public static void main(String[] args) {
    	HttpConnector connector = new HttpConnector();
    	new Thread(connector).start();
    }
}
