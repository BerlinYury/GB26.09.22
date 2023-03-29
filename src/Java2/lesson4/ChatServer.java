package Java2.lesson4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    WindowServer windowServer;

    private static final String END = "/end";
    private static final int PORT = 8967;

    public static String getEND() {
        return END;
    }

    public static int getPORT() {
        return PORT;
    }

    public ChatServer(WindowServer windowServer) {
        this.windowServer = windowServer;
        openSocketServer();
    }

    public void openSocketServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер ожидает подключение клиента");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread threadServ = new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        if (END.equals(msg)) {
                            out.writeUTF(msg);
                            break;
                        }
                        windowServer.addMessage("Client: " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            });
            threadServ.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Сервер закрыт");
        System.exit(0);
    }

    public void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

