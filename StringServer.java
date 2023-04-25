import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class StringServer{
    private static String message = "";

    public static void main(String[] args) throws Exception {
        if(args.length == 0){
            System.out.println("Missing port numer! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/add-message", new MyHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server Started! Visit http://localhost:" + port + "/add-message?s=");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "";
            URI url = t.getRequestURI();
            String query = url.getQuery();
            String[] word = query.split("=");

            if(word.length == 2 && word[1] != null && !word[1].isEmpty()) {
                message += "\n" + word[1];
            }

            response = message;

            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
